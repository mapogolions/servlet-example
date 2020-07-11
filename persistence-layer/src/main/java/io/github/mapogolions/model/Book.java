package io.github.mapogolions.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book", schema = "public")
public class Book {
    @Id
    private String isbn;

    @Column(nullable = false)
    private String author;

    public Book(String isbn, String author) {
        this.isbn = isbn;
        this.author = author;
    }

    public Book() { }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
