package dev.cetin.bookstore.service;

import dev.cetin.bookstore.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    Book update(Long id, Book book);
    Book save (Book book);
    Book delete (Long id);
}
