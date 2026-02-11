package com.example.AS0525U5W2D3.Controllers;

import com.example.S0525U5W2D2.Entities.Author;
import com.example.S0525U5W2D2.Payloads.NewAuthorPayload;
import com.example.S0525U5W2D2.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> findAll() {
        return this.authorService.findAll();
    }

    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable int authorId) {
        return this.authorService.findById(authorId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createBlog(@RequestBody NewAuthorPayload payload) {
        return this.authorService.saveAuthor(payload);
    }

    @PutMapping("/{authorId}")
    public Author getAuthorByIdAndUpdate(@PathVariable int authorId, @RequestBody NewAuthorPayload payload) {
        return this.authorService.findByIdAndUpdate(authorId, payload);
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getByIdAndDelete(@PathVariable int authorId) {
        this.authorService.findByIdAndDelete(authorId);
    }
}
