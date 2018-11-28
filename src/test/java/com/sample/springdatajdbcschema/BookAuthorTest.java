package com.sample.springdatajdbcschema;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJdbcTest
public class BookAuthorTest {

    @Autowired
    BookRepository books;

    @Autowired
    AuthorRepository authors;

    @Test
    public void booksAndAuthors() {

        Author author = new Author();
        author.name = "Greg L. Turnquist";

        author = authors.save(author);

        Book book = new Book();
        book.title = "Spring Boot";
        book.addAuthor(author);

        books.save(book);

        books.findAll();

        books.deleteAll();

        assertThat(authors.count()).isEqualTo(1);
    }
}