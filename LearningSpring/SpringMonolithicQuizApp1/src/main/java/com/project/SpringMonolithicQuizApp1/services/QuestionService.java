package com.project.SpringMonolithicQuizApp1.services;

import com.project.SpringMonolithicQuizApp1.models.Question;
import com.project.SpringMonolithicQuizApp1.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository repository;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(repository.findAll(), HttpStatusCode.valueOf(202));
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category){
        try{
            return new ResponseEntity<>(repository.findByCategory(category), HttpStatusCode.valueOf(202));
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try{
            repository.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("failure", HttpStatus.BAD_REQUEST);
        }
    }
}
