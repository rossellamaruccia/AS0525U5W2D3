package com.example.AS0525U5W2D3.Services;

import com.example.AS0525U5W2D3.Entities.Author;
import com.example.AS0525U5W2D3.Payloads.NewAuthorPayload;
import com.example.AS0525U5W2D3.Repositories.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author saveAuthor(NewAuthorPayload payload) {

//        this.authorRepository.findByEmail(payload.getEmail()).ifPresent(( author -> {
//            throw new BadRequestException("L'email " + author.getEmail() + " è già in uso!");
//        });

        Author newAuthor = new Author(payload.getName(), payload.getSurname(), payload.getEmail(), payload.getBirthDate());
        newAuthor.setAvatarUrl("https://ui.avatars.com/api?name=" + payload.getName() + "+" + payload.getSurname());
        this.authorRepository.save(newAuthor);
        log.info("l'autore " + newAuthor.getId() + " è stato aggiunto");
        return newAuthor;
    }

    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    public Author findById(UUID authorId) {
        Author found = null;
        for (Author author : this.authorRepository.findAll()) {
            if (author.getId() == authorId) {
                found = author;
            }
            if (found == null) log.info("Autore non trovato!");
        }
        return found;
    }

    public Author findByIdAndUpdate(UUID authorId, NewAuthorPayload payload) {
        Author found = null;
        for (Author author : this.authorRepository.findAll()) {
            if (author.getId() == authorId) {
                found = author;
                found.setName(payload.getName());
                found.setSurname(payload.getSurname());
                found.setEmail(payload.getEmail());
                found.setBirthDate(payload.getBirthDate());
            }
        }
        if (found == null) log.info("Autore non trovato");
        return found;
    }

    public void findByIdAndDelete(UUID authorId) {
        Author found = null;
        for (Author author : this.authorRepository.findAll()) {
            if (author.getId() == authorId) {
                found = author;
            }
            if (found == null) log.info("Autore non trovato");
        }
        this.authorRepository.findAll().remove(found);
    }
}
