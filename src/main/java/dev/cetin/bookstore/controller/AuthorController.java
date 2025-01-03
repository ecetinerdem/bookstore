package dev.cetin.bookstore.controller;

import dev.cetin.bookstore.dto.AuthorRequest;
import dev.cetin.bookstore.dto.AuthorResponse;
import dev.cetin.bookstore.entity.Author;
import dev.cetin.bookstore.entity.Book;
import dev.cetin.bookstore.service.AuthorService;
import dev.cetin.bookstore.service.BookService;
import dev.cetin.bookstore.util.Converter;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    private final BookService bookService;

    @GetMapping
    public List<AuthorResponse> findAll() {
        List<Author> authors = authorService.findAll();
        return Converter.authorResponseConvert(authors);
    }

    @GetMapping("/{id}")
    public AuthorResponse findById(@PathVariable("id") Long id) {
        Author foundAuthor = authorService.findById(id);
        return Converter.authorResponseConvert(foundAuthor);
    }

    @Transactional
    @PostMapping
    public AuthorResponse save(@Validated @RequestBody AuthorRequest authorRequest) {
        Author foundAuthor = authorRequest.getAuthor();
        authorService.save(foundAuthor);
        return Converter.authorResponseConvert(foundAuthor);
    }

    @Transactional
    @PutMapping("/{id}")
    public AuthorResponse update(@PathVariable("id") Long id, @Validated @RequestBody AuthorRequest authorRequest) {
        Author foundAuthor = authorRequest.getAuthor();
        authorService.save(foundAuthor);
        return Converter.authorResponseConvert(foundAuthor);
    }
    @Transactional
    @DeleteMapping("/{id}")
    public AuthorResponse delete(@PathVariable("id") Long id) {
        Author foundAuthor = authorService.findById(id);
        authorService.delete(id);
        return Converter.authorResponseConvert(foundAuthor);
    }

}
