package dev.cetin.bookstore.controller;

import dev.cetin.bookstore.dto.BookRequest;
import dev.cetin.bookstore.dto.BookResponse;
import dev.cetin.bookstore.entity.Author;
import dev.cetin.bookstore.entity.Book;
import dev.cetin.bookstore.service.AuthorService;
import dev.cetin.bookstore.service.BookService;
import dev.cetin.bookstore.util.Converter;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    @GetMapping
    public List<BookResponse> findAll() {
        List<Book> books = bookService.findAll();
        return Converter.bookResponseConvert(books);
    }

    @GetMapping("/{id}")
    public BookResponse findById(@PathVariable("id") Long id) {
        Book foundBook = bookService.findById(id);
        return Converter.bookResponseConvert(foundBook);
    }

    @Transactional
    @PostMapping
    public BookResponse save(@Validated @RequestBody BookRequest bookRequest) {
        Book foundBook = bookRequest.getBook();
        Author foundAuthor = bookRequest.getAuthor();
        bookService.save(foundBook);
        authorService.save(foundAuthor);
        return Converter.bookResponseConvert(foundBook);
    }

    @Transactional
    @PutMapping("/{id}")
    public BookResponse update (@PathVariable("id") Long id, @Validated @RequestBody BookRequest bookRequest) {
        Book foundBook = bookRequest.getBook();
        Author foundAuthor = bookRequest.getAuthor();
        bookService.save(foundBook);
        authorService.save(foundAuthor);
        return Converter.bookResponseConvert(foundBook);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public BookResponse delete(@PathVariable("id") Long id) {
        Book foundBook = bookService.findById(id);
        bookService.delete(id);
        return Converter.bookResponseConvert(foundBook);
    }
}
