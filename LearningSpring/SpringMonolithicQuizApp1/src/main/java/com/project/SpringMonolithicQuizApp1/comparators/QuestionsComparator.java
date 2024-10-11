package com.project.SpringMonolithicQuizApp1.comparators;

import com.project.SpringMonolithicQuizApp1.models.Question;

import java.util.Comparator;

public class QuestionsComparator implements Comparator<Question> {
    @Override
    public int compare(Question o1, Question o2) {
        return o1.getId() - o2.getId();
    }
}
