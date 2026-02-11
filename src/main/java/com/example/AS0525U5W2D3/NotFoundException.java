package com.example.AS0525U5W2D3;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("La risorsa con id " + id + " non è stata trovata!");
    }
}
