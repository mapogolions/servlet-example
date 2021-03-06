package io.github.mapogolions.hibernatecli.basics.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book", schema = "basics")
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
