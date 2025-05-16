package ru.novozhilov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.novozhilov.model.Book;
import ru.novozhilov.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getRandomBook() {
        return bookService.getRandomBook();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

}
