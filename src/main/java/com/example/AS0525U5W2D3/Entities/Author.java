package com.example.AS0525U5W2D3.Entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    public UUID id;
    public String name;
    public String surname;
    public String email;
    public LocalDate birthDate;
    public String avatarUrl;

    public Author(String name, String surname, String email, LocalDate date) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = date;
    }
}
