package dev.cetin.bookstore.dto;

import dev.cetin.bookstore.entity.Book;

import java.time.LocalDate;
import java.util.List;

public record AuthorResponse(Long id, String firstName, String lastName, LocalDate birthDate, List<Book> books) {
}
