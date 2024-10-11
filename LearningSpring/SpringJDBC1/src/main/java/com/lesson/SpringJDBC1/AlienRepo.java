package com.lesson.SpringJDBC1;

import com.lesson.SpringJDBC1.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlienRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alien alien){
        String sql = "insert into alien (id, name, technology) values (?, ?, ?)";

        int rows = template.update(sql, alien.getId(), alien.getName(), alien.getTechnology());
        System.out.println(rows);
    }

    public List<Alien> getAll(){
        return template.query("select * from alien", (rs, rowNum) -> {
            Alien alien = new Alien();
            alien.setId(rs.getInt(1));
            alien.setName(rs.getString(2));
            alien.setTechnology(rs.getString(3));
            return alien;
        });
    }
}
