package com.example.AS0525U5W2D3.Services;

import com.example.S0525U5W2D2.Entities.Blog;
import com.example.S0525U5W2D2.Payloads.NewBlogPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BlogService {
    private List<Blog> blogsDB = new ArrayList<>();

    public List<Blog> findAll() {
        return this.blogsDB;
    }

    public Blog saveBlog(NewBlogPayload payload) {
        Blog newBlog = new Blog(payload.getTitle(), payload.getCategory(), payload.getCover(), payload.getContent(), payload.getReadingTime());
        this.blogsDB.add(newBlog);
        log.info("il blog " + newBlog.getId() + " è stato aggiunto");
        return newBlog;
    }

    public Blog findById(int blogId) {
        Blog found = null;
        for (Blog blog : blogsDB) {
            if (blog.getId() == blogId) {
                found = blog;
            }
            if (found == null) log.info("Blog non trovato!");
        }
        return found;
    }

    public Blog findByIdAndUpdate(int blogId, NewBlogPayload payload) {
        Blog found = null;
        for (Blog blog : this.blogsDB) {
            if (blog.getId() == blogId) {
                found = blog;
                found.setTitle(payload.getTitle());
                found.setCategory(payload.getCategory());
                found.setCover(payload.getCover());
                found.setReadingTime(payload.getReadingTime());
            }
        }
        if (found == null) log.info("Blog non trovato");
        return found;
    }

    public void findByIdAndDelete(int blogId) {
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
