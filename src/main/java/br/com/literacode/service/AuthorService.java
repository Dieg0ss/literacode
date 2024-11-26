package br.com.literacode.service;

import br.com.literacode.model.Author;
import br.com.literacode.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Service
public class AuthorService {

    @Autowired
    private BookRepository repository;

    private final Scanner scanner = new Scanner(System.in);

    public void listRegisteredAuthors() {

        List<Author> authors = repository.findAllAuthors();
        if (authors.isEmpty()) {
            System.err.println("Nenhum autor registrado no banco de dados.");
        } else {
            authors.forEach(System.out::println);
        }

    }

    public void listAuthorsAliveInYear() {

        try {
            System.out.println("Digite o ano para pesquisa: ");
            var yearSearch = scanner.nextInt();

            List<Author> authors = repository.findAllAuthorsAliveInYear(yearSearch);
            if (authors.isEmpty()) {
                System.err.println("Nenhum autor encontrado para este ano.");
            } else {
                authors.forEach(System.out::println);
            }
        } catch (InputMismatchException e) {
            System.err.println("Digite um ano válido!");
            scanner.nextLine();
        }
    }
}
