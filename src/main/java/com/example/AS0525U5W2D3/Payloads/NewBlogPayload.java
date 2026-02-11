package com.example.AS0525U5W2D3.Payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class NewBlogPayload {
    private int id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private double readingTime;
}
