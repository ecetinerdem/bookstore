package dev.cetin.bookstore.service;

import dev.cetin.bookstore.entity.Book;
import dev.cetin.bookstore.exceptions.BookException;
import dev.cetin.bookstore.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookException("Book Not Found With Id " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Book update(Long id, Book book) {
        Book foundBook = findById(id);
        return bookRepository.save(foundBook);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book delete(Long id) {
        Book foundBook = bookRepository.findById(id).orElseThrow(() -> new BookException("Book Not Found With Id " + id, HttpStatus.NOT_FOUND));
        bookRepository.delete(foundBook);
        return foundBook;
    }
}
