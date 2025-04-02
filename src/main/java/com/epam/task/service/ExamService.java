package com.epam.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.task.model.Exam;
import com.epam.task.repository.ExamRepository;
import com.epam.task.repository.StudentRepository;
import com.epam.task.repository.SubjectRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ExamService {

    private static final int MAX_EXAMS = 1_000_000;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ExamRepository examRepository;

    public void populateExamData() {
        log.info("Populating exam data...");

        int studentIndex = studentRepository.getMinIndex();
        int subjectIndex = subjectRepository.getMinIndex();
        log.info("Student index: " + studentIndex);
        log.info("Subject index: " + subjectIndex);

        for (int i = 0; i < MAX_EXAMS; i++) {
            char mark = i % 2 == 0 ? 'A' : 'B';

            Exam exam = new Exam();
            exam.setStudentId(studentIndex);
            exam.setSubjectId(subjectIndex);
            exam.setMark(mark);

            examRepository.saveExam(exam);
            subjectIndex++;

            if (subjectIndex > subjectRepository.getMaxIndex()) {
                subjectIndex = subjectRepository.getMinIndex();
                studentIndex++;
            }
        }
    }


}
