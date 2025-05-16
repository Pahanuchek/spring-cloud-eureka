package ru.novozhilov.repository;

import org.springframework.stereotype.Repository;
import ru.novozhilov.model.Issue;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IssueRepository {
    private List<Issue> issues = new ArrayList<>();

    public void addIssue(Issue issue) {
        issues.add(issue);
    }

    public List<Issue> getAllIssue() {
        return issues;
    }
}
