package com.epam.task.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.epam.task.model.Subject;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JDBCSubjectRepository implements SubjectRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveSubject(Subject subject) {
        String sql = "INSERT INTO public.\"Subject\" (name, tutor) VALUES (?, ?)";
        jdbcTemplate.update(sql, subject.getName(), subject.getTutor());
    }

    @Override
    public int getMinIndex() {        
        // Implementation for getting the minimum index from the database
        // This is a placeholder implementation and should be replaced with actual JDBC code
        String sql = "SELECT MIN(id) FROM public.\"Subject\"";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int getMaxIndex() {        
        // Implementation for getting the minimum index from the database
        // This is a placeholder implementation and should be replaced with actual JDBC code
        String sql = "SELECT MAX(id) FROM public.\"Subject\"";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
    
}
