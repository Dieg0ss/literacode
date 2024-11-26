package br.com.literacode.service;


import br.com.literacode.model.Book;
import br.com.literacode.model.BookData;
import br.com.literacode.model.BookDataWrapper;
import br.com.literacode.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private GutendexApi apiConsumption;

    @Autowired
    private ConvertData converter;

    private final String URL_API = "https://gutendex.com/books?search=";

    private final Scanner scanner = new Scanner(System.in);

    public BookData getBookData() {

        System.out.println("Digite o título do livro para busca: ");
        var bookeTitle = scanner.nextLine();
        var json = apiConsumption.getData(URL_API + bookeTitle.toLowerCase().replace(" ", "+"));
        BookDataWrapper bookDataWrapper = converter.getConvertedData(json, BookDataWrapper.class);

        if (bookDataWrapper.results() != null && !bookDataWrapper.results().isEmpty()) {
            return bookDataWrapper.results().get(0);
        } else {
            return null;
        }
    }

    public void bookSearch() {

        BookData bookData = getBookData();
        if(bookData != null) {
            Book book = new Book(bookData);
            System.out.println(book);
            repository.save(book);

        } else {
            System.err.println("Nenhum livro encontrado para o título informado.");
        }
    }

    public void listRegisteredBooks() {

        List<Book> books = repository.findAll();
        books.forEach(System.out::println);
    }

    public void listBooksInLanguage() {

        var languagesMenu = """
                *=*=*=*=*=* Escolha o idioma para busca *=*=*=*=*=*
                pt - Português
                en - Inglês
                es - Espanhol
                fr - Francês
                """;

        System.out.println(languagesMenu);
        var languageChoice = scanner.nextLine();

        List<Book> booksInLanguage = repository.findAllBooksByLanguage(languageChoice.toLowerCase());
        if (booksInLanguage.isEmpty()) {
            System.err.println("Nenhum livro encontrado para este idioma.");
        } else {
            booksInLanguage.forEach(System.out::println);
            System.out.println("Total de " + booksInLanguage.size() + " livro(s) encontrados no idioma '" + booksInLanguage.get(0).getLanguage() + "'");
        }
    }

    public void listTop10DownloadedBooks() {

        var json = apiConsumption.getData(URL_API);
        BookDataWrapper bookDataWrapper = converter.getConvertedData(json, BookDataWrapper.class);

        if (bookDataWrapper.results() != null && !bookDataWrapper.results().isEmpty()) {
            List<BookData> bookData = bookDataWrapper.results()
                    .stream()
                    .limit(10)
                    .collect(Collectors.toList());

            List<Book> topBooks = bookData
                    .stream()
                    .map(Book::new)
                    .sorted(Comparator.comparing(Book::getDownloadCount).reversed())
                    .collect(Collectors.toList());

            System.out.println("*=*=*=*=*=* Top 10 livros mais baixados *=*=*=*=*=*");
            topBooks.forEach(System.out::println);
        } else {
            System.err.println("Nenhum livro encontrado.");
        }
    }
}
