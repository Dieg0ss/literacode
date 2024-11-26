package br.com.literacode.model;


import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Book book;

    private String name;

    private Integer birthYear;

    private Integer deathYear;


    public Author(){}

    public Author(AuthorData authorData){
        this.name = authorData.name();
        this.birthYear = authorData.birth_year();
        this.deathYear = authorData.death_year();
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    @Override
    public String toString() {
        return "Autor: " + name + "\n" +
                "Ano de nascimento: " + birthYear + "\n" +
                "Ano de falecimento: " + deathYear + "\n" +
                "Livro: " + book.getTitle() + "\n";
    }
}
