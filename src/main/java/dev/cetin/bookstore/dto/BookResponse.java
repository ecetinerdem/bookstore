package dev.cetin.bookstore.dto;

import dev.cetin.bookstore.entity.Author;
import dev.cetin.bookstore.entity.Genre;

import java.time.LocalDate;

public record BookResponse(Long id, String title, Genre genre, LocalDate publishDate,Author author) {
}
