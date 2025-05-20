package ru.novozhilov.service;

import com.novozhilov.annotation.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.novozhilov.model.Book;
import ru.novozhilov.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Timer
    public Book getRandomBook() throws InterruptedException {
        Thread.sleep(1000);
        return bookRepository.getRandomBook();
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
}
