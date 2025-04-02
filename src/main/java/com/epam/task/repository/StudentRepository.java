package com.epam.task.repository;

import org.springframework.stereotype.Repository;

import com.epam.task.model.Student;

@Repository
public interface StudentRepository {
    
    void saveStudent(Student student);

    int getMinIndex();

    int getMaxIndex();
}
