package com.example.AS0525U5W2D3.Payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
public class NewBlogPayload {
    private String title;
    private String category;
    private String content;
    private double readingTime;
    private UUID authorId;
}
