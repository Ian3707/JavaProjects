package com.lesson;

import com.lesson.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien, Integer> {
    //List<Alien> findByName(String name);
    //List<Alien> findByNameOrderByIdDesc(String name); sql syntax

    @Query("from Alien where name=:name")
    List<Alien> find(@Param("name") String name);
}
