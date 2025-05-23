package ru.novozhilov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private UUID id;
    private String firstName;
    private String lastName;
}
