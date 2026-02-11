package com.example.AS0525U5W2D3.Services;

import com.example.AS0525U5W2D3.Entities.Author;
import com.example.AS0525U5W2D3.Entities.Blog;
import com.example.AS0525U5W2D3.NotFoundException;
import com.example.AS0525U5W2D3.Payloads.NewBlogPayload;
import com.example.AS0525U5W2D3.Repositories.AuthorRepository;
import com.example.AS0525U5W2D3.Repositories.BlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BlogService {
    private BlogRepository blogRepository;
    private AuthorRepository authorRepository;
    private List<Blog> blogsDB = new ArrayList<>();

    @Autowired
    public BlogService(BlogRepository blogRepository, AuthorRepository authorRepository) {
        this.blogRepository = blogRepository;
        this.authorRepository = authorRepository;
    }

    public List<Blog> findAll() {
        return this.blogsDB;
    }

    public Blog saveBlog(NewBlogPayload payload) {
        Optional optional = this.authorRepository.findById(payload.getAuthorId());
        if (optional.isPresent()) {
            Blog newBlog = new Blog(payload.getTitle(), payload.getCategory(), payload.getContent(), payload.getReadingTime(), (Author) optional.get());
            newBlog.setCover("https://ui.avatars.com/api?title=" + payload.getTitle());
            this.blogsDB.add(newBlog);
            this.blogRepository.save(newBlog);
            log.info("il blog " + newBlog.getId() + " è stato aggiunto");
            return newBlog;
        } else throw new NotFoundException(payload.getAuthorId());
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
