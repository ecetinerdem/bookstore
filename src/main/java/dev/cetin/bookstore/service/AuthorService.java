package dev.cetin.bookstore.service;


import dev.cetin.bookstore.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author findById(Long id);
    Author update(Long id, Author author);
    Author save(Author author);
    Author delete(Long id);
}
