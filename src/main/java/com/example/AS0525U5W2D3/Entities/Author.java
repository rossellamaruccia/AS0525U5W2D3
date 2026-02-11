package com.example.AS0525U5W2D3.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Author {
    public int id;
    public String name;
    public String surname;
    public String email;
    public LocalDate birthDate;
    public String avatar;

    public Author(String name, String surname, String email, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
    }
}
