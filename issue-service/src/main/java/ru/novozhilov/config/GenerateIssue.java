package ru.novozhilov.config;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.novozhilov.model.Issue;
import ru.novozhilov.repository.IssueRepository;
import ru.novozhilov.service.BookProvider;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Component
public class GenerateIssue {
    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private BookProvider bookProvider;

    private final Faker faker = new Faker();

    @PostConstruct
    public void generateIssue() {
        for (int i = 0; i < 15; i++) {
            Issue issue = new Issue();
            issue.setId(UUID.randomUUID());
            issue.setBook(bookProvider.getRandomBook());
            issue.setReaderId(UUID.randomUUID());
            issue.setIssuedAt(faker.date().between(startOfDate(),
                    endOfDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

            issueRepository.addIssue(issue);
        }
    }
    private Date startOfDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2025);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        return calendar.getTime();
    }

    private Date endOfDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2025);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, 31);

        return calendar.getTime();
    }
}
