package com.project.QuizService.controllers;

import com.project.QuizService.models.QuizDTO;
import com.project.QuizService.models.QuestionWrapper;
import com.project.QuizService.models.Response;
import com.project.QuizService.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService service;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDto){
        return service.createQuiz(quizDto.getCategory(), quizDto.getNumQ(), quizDto.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizById(@PathVariable int id){
        return service.getQuizQuestionsById(id);
    }

    @PostMapping("submit")
    public ResponseEntity<Integer> submitQuiz(@RequestBody List<Response> responses){
        return service.calculateResult(responses);
    }
}
