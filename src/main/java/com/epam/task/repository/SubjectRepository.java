package com.epam.task.repository;

import org.springframework.stereotype.Repository;

import com.epam.task.model.Subject;

@Repository
public interface SubjectRepository {
    
    void saveSubject(Subject subject);

    int getMinIndex();

    int getMaxIndex();
}
