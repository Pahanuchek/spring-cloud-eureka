package ru.novozhilov.repository;

import org.springframework.stereotype.Repository;
import ru.novozhilov.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class BookRepository {
    private List<Book> books = new ArrayList<>();
    private Random random = new Random();

    public Book getRandomBook() {
        return books.get(random.nextInt(0, books.size()));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
