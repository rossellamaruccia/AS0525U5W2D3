package com.example.AS0525U5W2D3.Entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private double readingTime;
    @ManyToOne
    private Author author;

    public Blog() {
    }

    public Blog(String title, String category, String content, double readingTime, Author author) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.readingTime = readingTime;
        this.author = author;
    }
}
