package com.project.SpringMonolithicQuizApp1.controllers;

import com.project.SpringMonolithicQuizApp1.models.Question;
import com.project.SpringMonolithicQuizApp1.models.QuestionWrapper;
import com.project.SpringMonolithicQuizApp1.models.Response;
import com.project.SpringMonolithicQuizApp1.services.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService service;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return service.createQuiz(category, numQ, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizById(@PathVariable int id){
        return service.getQuizQuestionsById(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> responses){
        return service.calculateResult(id, responses);
    }
}
