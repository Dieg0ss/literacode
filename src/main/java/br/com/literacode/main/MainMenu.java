package br.com.literacode.main;

import br.com.literacode.repository.BookRepository;
import br.com.literacode.service.AuthorService;
import br.com.literacode.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;

import java.util.Scanner;

@Component
public class MainMenu {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookRepository repository;

    private Scanner scanner = new Scanner(System.in);

    public MainMenu(){}

    public void showMenu() {

        var choice = -1;
        while (choice != 0) {

            printMenu();
            try {

                choice = scanner.nextInt();
                scanner.nextLine();
                handleChoice(choice);

            } catch (InputMismatchException e){
                System.err.println("Erro: Por favor, insira um número válido.");
                scanner.nextLine();
                System.out.println();
            }
        }
    }

    private void printMenu(){
        var menu = """
                    *=*=*=*=*=* Escolha uma opção *=*=*=*=*=*
                    
                    1 - Buscar livro
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idioma
                    6 - Top 10 livros mais baixados
                    
                    0- Sair
                    """;

        System.out.println(menu);

    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1 -> bookService.bookSearch();
            case 2 -> bookService.listRegisteredBooks();
            case 3 -> authorService.listRegisteredAuthors();
            case 4 -> authorService.listAuthorsAliveInYear();
            case 5 -> bookService.listBooksInLanguage();
            case 6 -> bookService.listTop10DownloadedBooks();
            case 0 -> System.out.println("Programa encerrado.");
            default -> System.err.println("Opção inválida! Digite novamente.");
        }
    }
}
