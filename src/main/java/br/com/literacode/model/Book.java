package br.com.literacode.model;

import jakarta.persistence.*;


@Entity
@Table(name = "livros")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Author author;

    private String language;

    private Integer downloadCount;

    public Book(){

    }

    public Book(BookData bookData) {
        this.title = bookData.title();
        this.language = (bookData.languages() != null && !bookData.languages().isEmpty())
                ? bookData.languages().get(0)
                : null;
        this.downloadCount = bookData.download_count();
        if (bookData.authors() != null && !bookData.authors().isEmpty()) {
            Author newAuthor = new Author(bookData.authors().get(0));
            this.author = newAuthor;
            newAuthor.setBook(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    @Override
    public String toString() {
        return "*-*-*-*- Livro *-*-*-*-\n" +
                "Titúlo: " + title + "\n" +
                "Autor: " + author.getName() + "\n" +
                "Idioma: " + language + "\n" +
                "Número de downloads: " + downloadCount + "\n";
    }
}
