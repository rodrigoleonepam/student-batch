package com.epam.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.task.model.Subject;
import com.epam.task.repository.SubjectRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SubjectService {

    private static final int MAX_SUBJECTS = 1000;
    
    @Autowired
    private SubjectRepository subjectRepository;

    public void populateSubjectData() {
        log.info("Populating subject data...");

        for (int i=0; i<MAX_SUBJECTS; i++) {
            Subject subject = new Subject();
            subject.setId(i);
            subject.setName("Subject" + i);
            subject.setTutor("Tutor" + i);

            subjectRepository.saveSubject(subject);
        }
    }


}
