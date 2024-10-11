package com.project.QuizService.models;

import lombok.Data;

@Data
public class QuizDTO {
    private String category;
    private int numQ;
    private String title;
}
