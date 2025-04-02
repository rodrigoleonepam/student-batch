package com.epam.task.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.epam.task.model.Exam;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JDBCExamRepository implements ExamRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveExam(Exam exam) {
        String sql = "INSERT INTO public.\"Exam\" (student_id, subject_id, mark) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, exam.getStudentId(), exam.getSubjectId(), exam.getMark());
    }
    
}
