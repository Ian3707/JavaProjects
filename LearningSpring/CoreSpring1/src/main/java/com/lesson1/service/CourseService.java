package com.lesson1.service;

import com.lesson1.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseService implements CrudService<Course>{

    private List<Course> courses;

    public CourseService(){
        courses = new ArrayList<Course>();
        Course springWoBoot = new Course(1,
                "Boot free spring course",
                "Starting new spring app without spring boot",
                "#link");

        courses.add(springWoBoot);
    }

    @Override
    public List<Course> list() {
        return courses;
    }

    @Override
    public Course create(Course course) {
        return null;
    }

    @Override
    public Optional<Course> get(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Course course, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
