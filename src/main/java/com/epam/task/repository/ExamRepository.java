package com.epam.task.repository;

import org.springframework.stereotype.Repository;

import com.epam.task.model.Exam;

@Repository
public interface ExamRepository {
    
    void saveExam(Exam exam);
}
