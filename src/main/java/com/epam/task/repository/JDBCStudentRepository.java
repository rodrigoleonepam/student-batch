package com.epam.task.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.epam.task.model.Student;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JDBCStudentRepository implements StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveStudent(Student student) {
        // Implementation for saving student to the database using JDBC
        // This is a placeholder implementation and should be replaced with actual JDBC code
        // log.info("Saving student: " + student);
        String sql = "INSERT INTO public.\"Student\" (name, surname, birth_date, phone_number, primary_skill, created_datetime, updated_datetime) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, student.getName(), student.getSurname(), student.getBirthDate(), 
                student.getPhoneNumber(), student.getPrimarySkill(), student.getCreatedDateTime(), 
                student.getUpdatedDateTime());
    }

    @Override
    public int getMinIndex() {        
        // Implementation for getting the minimum index from the database
        // This is a placeholder implementation and should be replaced with actual JDBC code
        String sql = "SELECT MIN(id) FROM public.\"Student\"";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int getMaxIndex() {        
        // Implementation for getting the minimum index from the database
        // This is a placeholder implementation and should be replaced with actual JDBC code
        String sql = "SELECT MAX(id) FROM public.\"Student\"";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
    
}
