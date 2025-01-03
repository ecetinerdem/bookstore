package dev.cetin.bookstore.dto;

import dev.cetin.bookstore.entity.Author;
import dev.cetin.bookstore.entity.Book;
import lombok.Data;

import java.util.List;

@Data
public class AuthorRequest {
    private List<Book> books;
    private Author author;
}
