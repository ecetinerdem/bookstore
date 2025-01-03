package dev.cetin.bookstore.service;

import dev.cetin.bookstore.entity.Author;
import dev.cetin.bookstore.exceptions.AuthorException;
import dev.cetin.bookstore.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements  AuthorService{
    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new AuthorException("Author Not Found With Id "+ id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Author update(Long id, Author author) {
        Author foundAuthor = authorRepository.findById(id).orElseThrow(() -> new AuthorException("Author Not Found With Id "+ id, HttpStatus.NOT_FOUND));
        return authorRepository.save(foundAuthor);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author delete(Long id) {
        Author foundAuthor = authorRepository.findById(id).orElseThrow(() -> new AuthorException("Author Not Found With Id "+ id, HttpStatus.NOT_FOUND));
        authorRepository.delete(foundAuthor);
        return foundAuthor;
    }
}
