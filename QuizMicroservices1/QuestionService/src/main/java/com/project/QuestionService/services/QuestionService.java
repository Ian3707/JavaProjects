package com.project.QuestionService.services;

import com.project.QuestionService.models.Question;
import com.project.QuestionService.models.QuestionWrapper;
import com.project.QuestionService.models.Response;
import com.project.QuestionService.repositories.QuestionRepository;
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

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, int numQ) {
        List<Integer> questions = repository.findNRandomQuestionsByCategory(category, numQ);

        return new ResponseEntity<List<Integer>>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsById(List<Integer> questionsId) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        for(int id : questionsId){
            questions.add(repository.findById(id).get());
        }

        for(Question question : questions){
            wrappers.add(new QuestionWrapper(
                    question.getId(), question.getOption1(), question.getOption2(),
                    question.getOption3(), question.getOption4(), question.getQuestion()));
        }

        return new ResponseEntity<>(wrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int correctAmount = 0;

        for(Response response : responses){
            Question question = repository.findById(response.getId()).get();
            if(response.getResponse().equals(question.getAnswer())){
                ++correctAmount;
            }
        }

        return new ResponseEntity<Integer>(correctAmount, HttpStatus.OK);
    }
}
