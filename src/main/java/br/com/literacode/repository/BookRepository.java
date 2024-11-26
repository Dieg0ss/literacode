package br.com.literacode.repository;

import br.com.literacode.model.Author;
import br.com.literacode.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b.author FROM Book b")
    List<Author> findAllAuthors();

    @Query("SELECT b.author FROM Book b WHERE :yearSearch >= b.author.birthYear AND :yearSearch <= b.author.deathYear")
    List<Author> findAllAuthorsAliveInYear(int yearSearch);

    @Query("SELECT b FROM Book b WHERE b.language ILIKE %:languageChoice%")
    List<Book> findAllBooksByLanguage(String languageChoice);
}
