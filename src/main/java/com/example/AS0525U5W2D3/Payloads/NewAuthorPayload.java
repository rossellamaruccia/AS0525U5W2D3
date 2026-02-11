package com.example.AS0525U5W2D3.Payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
public class NewAuthorPayload {
    public int id;
    public String name;
    public String surname;
    public String email;
    public LocalDate birthDate;
    public String avatar;
}
