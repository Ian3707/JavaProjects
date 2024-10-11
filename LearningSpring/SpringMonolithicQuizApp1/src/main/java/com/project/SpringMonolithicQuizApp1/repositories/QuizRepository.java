package com.project.SpringMonolithicQuizApp1.repositories;

import com.project.SpringMonolithicQuizApp1.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
