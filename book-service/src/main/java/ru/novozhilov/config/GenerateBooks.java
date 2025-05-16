package ru.novozhilov.config;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.novozhilov.model.Author;
import ru.novozhilov.model.Book;
import ru.novozhilov.repository.BookRepository;

import java.util.UUID;

@Component
public class GenerateBooks {

    @Autowired
    private BookRepository bookRepository;
    private final Faker faker = new Faker();

    @PostConstruct
    public void generateBooks() {
        for (int i = 0; i < 15; i++) {
            Book book = new Book();
            book.setId(UUID.randomUUID());
            book.setName(faker.book().title());

            Author author = new Author();
            author.setId(UUID.randomUUID());
            author.setFirstName(faker.name().firstName());
            author.setLastName(faker.name().lastName());

            book.setAuthor(author);

            bookRepository.addBook(book);
        }
    }
}
