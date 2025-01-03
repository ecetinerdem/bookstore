package dev.cetin.bookstore.dto;

import dev.cetin.bookstore.entity.Author;
import dev.cetin.bookstore.entity.Book;
import lombok.Data;

import java.util.List;

@Data
public class BookRequest {
    Author author;
    Book book;
}
