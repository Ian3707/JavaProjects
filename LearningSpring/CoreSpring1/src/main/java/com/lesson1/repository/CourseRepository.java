package com.lesson1.repository;

import com.lesson1.model.Course;

import java.util.List;

public class CourseRepository implements CrudRepository<Course> {

    @Override
    public List<Course> findAll() {
        return List.of();
    }
}
