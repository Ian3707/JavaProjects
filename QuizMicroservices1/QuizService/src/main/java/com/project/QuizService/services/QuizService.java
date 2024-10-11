package com.project.QuizService.services;

import com.project.QuizService.feign.IQuizFeign;
import com.project.QuizService.models.QuestionWrapper;

import com.project.QuizService.models.Quiz;
import com.project.QuizService.models.Response;
import com.project.QuizService.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;

    @Autowired
    IQuizFeign quizFeign;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questionNumbers = quizFeign.getQuestionsForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questionNumbers);
        System.out.println(questionNumbers);
        quizRepository.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestionsById(int id) {
        Quiz quiz = quizRepository.findById(id).orElse(null);
        List<Integer> questionsIds = quiz.getQuestionIds();

        return quizFeign.getQuestionsById(questionsIds);
    }

    public ResponseEntity<Integer> calculateResult(List<Response> responses) {
        return quizFeign.getScore(responses);
    }
}
