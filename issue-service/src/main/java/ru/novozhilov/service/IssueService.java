package ru.novozhilov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.novozhilov.model.Issue;
import ru.novozhilov.repository.IssueRepository;

import java.util.List;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    public List<Issue> getAllIssue() {
        return issueRepository.getAllIssue();
    }
}
