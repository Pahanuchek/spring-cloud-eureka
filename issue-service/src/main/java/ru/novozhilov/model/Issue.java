package ru.novozhilov.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class Issue {
    private UUID id;
    private LocalDate issuedAt;
    private Book book;
    private UUID readerId;
}
