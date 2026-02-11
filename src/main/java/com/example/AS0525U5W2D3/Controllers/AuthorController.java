package com.example.AS0525U5W2D3.Controllers;

import com.example.AS0525U5W2D3.Entities.Author;
import com.example.AS0525U5W2D3.Payloads.NewAuthorPayload;
import com.example.AS0525U5W2D3.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public Page<Author> findAll(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size,
                                @RequestParam(defaultValue = "surname") String orderBy,
                                @RequestParam(defaultValue = "asc") String sortCriteria) {

        return this.authorService.findAll(page, size, orderBy, sortCriteria);
    }


    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable UUID authorId) {
        return this.authorService.findById(authorId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createBlog(@RequestBody NewAuthorPayload payload) {
        return this.authorService.saveAuthor(payload);
    }

    @PutMapping("/{authorId}")
    public Author getAuthorByIdAndUpdate(@PathVariable UUID authorId, @RequestBody NewAuthorPayload payload) {
        return this.authorService.findByIdAndUpdate(authorId, payload);
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getByIdAndDelete(@PathVariable UUID authorId) {
        this.authorService.findByIdAndDelete(authorId);
    }
}
