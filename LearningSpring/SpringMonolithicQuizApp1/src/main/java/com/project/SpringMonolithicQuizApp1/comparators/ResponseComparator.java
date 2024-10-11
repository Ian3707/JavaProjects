package com.project.SpringMonolithicQuizApp1.comparators;

import com.project.SpringMonolithicQuizApp1.models.Response;

import java.util.Comparator;

public class ResponseComparator implements Comparator<Response> {
    @Override
    public int compare(Response o1, Response o2) {
        return o1.getId() - o2.getId();
    }
}
