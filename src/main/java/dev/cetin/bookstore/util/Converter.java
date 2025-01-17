package dev.cetin.bookstore.util;

import dev.cetin.bookstore.dto.AuthorResponse;
import dev.cetin.bookstore.dto.BookResponse;
import dev.cetin.bookstore.entity.Author;
import dev.cetin.bookstore.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static List<BookResponse> bookResponseConvert(List<Book> books) {
        List<BookResponse> bookResponses = new ArrayList<>();
        for(Book book: books) {
            bookResponses.add(new BookResponse(book.getId(),book.getTitle(), book.getGenre(),book.getPublishDate(), book.getAuthor()));
        }
        return bookResponses;
    }

    public static BookResponse bookResponseConvert(Book book) {
        return new BookResponse(book.getId(),book.getTitle(), book.getGenre(),book.getPublishDate(), book.getAuthor());
    }

    public static List<AuthorResponse> authorResponseConvert(List<Author> authors) {
        List<AuthorResponse> authorResponses = new ArrayList<>();
        for (Author author: authors) {
            authorResponses.add(new AuthorResponse(author.getId(), author.getFirstName(), author.getLastName(), author.getBirthDate(),author.getBooks()));
        }
        return authorResponses;
    }
    public static AuthorResponse authorResponseConvert(Author author) {
        return new AuthorResponse(author.getId(), author.getFirstName(), author.getLastName(), author.getBirthDate(),author.getBooks());
    }
}
