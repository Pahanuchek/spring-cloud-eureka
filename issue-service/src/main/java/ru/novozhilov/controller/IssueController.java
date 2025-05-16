package ru.novozhilov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.novozhilov.model.Issue;
import ru.novozhilov.service.IssueService;

import java.util.List;

@RestController
@RequestMapping("/api/issue")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Issue> getAllIssue() {
        return issueService.getAllIssue();
    }
}
