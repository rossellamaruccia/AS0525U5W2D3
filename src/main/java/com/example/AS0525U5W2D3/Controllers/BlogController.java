package com.example.AS0525U5W2D3.Controllers;

import com.example.AS0525U5W2D3.Entities.Blog;
import com.example.AS0525U5W2D3.Payloads.NewBlogPayload;
import com.example.AS0525U5W2D3.Services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public List<Blog> findAll() {
        return this.blogService.findAll();
    }

    @GetMapping("/{blogId}")
    public Blog getBlogById(@PathVariable long blogId) {
        return this.blogService.findById(blogId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blog createBlog(@RequestBody NewBlogPayload payload) {
        return this.blogService.saveBlog(payload);
    }

    @PutMapping("/{blogId}")
    public Blog getBlogByIdAndUpdate(@PathVariable long blogId, @RequestBody NewBlogPayload payload) {
        return this.blogService.findByIdAndUpdate(blogId, payload);
    }

    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getByIdAndDelete(@PathVariable long blogId) {
        this.blogService.findByIdAndDelete(blogId);
    }
}
