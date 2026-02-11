package com.example.AS0525U5W2D3.Payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
public class NewAuthorPayload {
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;
}
