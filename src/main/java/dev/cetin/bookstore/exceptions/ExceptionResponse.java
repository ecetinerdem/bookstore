package dev.cetin.bookstore.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ExceptionResponse {
    private String message;
    private Integer status;
    private LocalDateTime dateTime;
}
