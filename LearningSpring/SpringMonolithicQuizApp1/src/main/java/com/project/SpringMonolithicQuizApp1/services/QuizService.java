package com.project.SpringMonolithicQuizApp1.services;

import com.project.SpringMonolithicQuizApp1.comparators.QuestionsComparator;
import com.project.SpringMonolithicQuizApp1.comparators.ResponseComparator;
import com.project.SpringMonolithicQuizApp1.models.Question;
import com.project.SpringMonolithicQuizApp1.models.QuestionWrapper;
import com.project.SpringMonolithicQuizApp1.models.Quiz;
import com.project.SpringMonolithicQuizApp1.models.Response;
import com.project.SpringMonolithicQuizApp1.repositories.QuestionRepository;
import com.project.SpringMonolithicQuizApp1.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionRepository.findNRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);

        return new ResponseEntity<String>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestionsById(int id) {
        Quiz quiz = quizRepository.findById(id).orElse(null);
        List<Question> questionsFromDB = quiz.getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for(Question question : questionsFromDB){
            questionsForUser.add(new QuestionWrapper(
                    question.getId(), question.getOption1(), question.getOption2(),
                    question.getOption3(), question.getOption4(), question.getQuestion()));
        }

        return new ResponseEntity<List<QuestionWrapper>>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        questions.sort(new QuestionsComparator());
        responses.sort(new ResponseComparator());
        int correctAmount = 0;
        int i = 0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getAnswer())){
                ++correctAmount;
            }
            ++i;
        }

        return new ResponseEntity<Integer>(correctAmount, HttpStatus.OK);
    }
}
