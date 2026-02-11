package com.example.AS0525U5W2D3.Services;

import com.example.AS0525U5W2D3.Entities.Author;
import com.example.AS0525U5W2D3.Entities.Blog;
import com.example.AS0525U5W2D3.Payloads.NewBlogPayload;
import com.example.AS0525U5W2D3.Repositories.BlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BlogService {
    private BlogRepository blogRepository;
    private AuthorService authorService;
    private List<Blog> blogsDB = new ArrayList<>();

    @Autowired
    public BlogService(BlogRepository blogRepository, AuthorService authorService) {
        this.blogRepository = blogRepository;
        this.authorService = authorService;
    }

    public List<Blog> findAll() {
        return this.blogsDB;
    }

    public Blog saveBlog(NewBlogPayload payload) {
        Author author = this.authorService.findById(payload.getAuthorId());
        Blog newBlog = new Blog(payload.getTitle(), payload.getCategory(), payload.getContent(), payload.getReadingTime(), author);
        newBlog.setCover("https://ui.avatars.com/api?title=" + payload.getTitle());
        this.blogsDB.add(newBlog);
        this.blogRepository.save(newBlog);
        log.info("il blog " + newBlog.getId() + " è stato aggiunto");
        return newBlog;
    }

    public Blog findById(long blogId) {
        Blog found = null;
        for (Blog blog : blogsDB) {
            if (blog.getId() == blogId) {
                found = blog;
            }
            if (found == null) log.info("Blog non trovato!");
        }
        return found;
    }

    public Blog findByIdAndUpdate(long blogId, NewBlogPayload payload) {
        Blog found = null;
        for (Blog blog : this.blogsDB) {
            if (blog.getId() == blogId) {
                found = blog;
                found.setTitle(payload.getTitle());
                found.setCategory(payload.getCategory());
                found.setReadingTime(payload.getReadingTime());
            }
        }
        if (found == null) log.info("Blog non trovato");
        return found;
    }

    public void findByIdAndDelete(long blogId) {
        Blog found = null;
        for (Blog blog : this.blogsDB) {
            if (blog.getId() == blogId) {
                found = blog;
            }
            if (found == null) log.info("Blog non trovato");
        }
        this.blogsDB.remove(found);
    }
}
