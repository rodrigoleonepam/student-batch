package com.epam.task.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.task.model.Student;
import com.epam.task.repository.StudentRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class StudentService {

    private static final int MAX_STUDENTS = 100_000;
    
    @Autowired
    private StudentRepository studentRepository;

    public void populateStudentData() {
        // Logic to populate student data
        // This is a placeholder implementation and should be replaced with actual logic
        log.info("Populating student data...");

        for (int i=0; i<MAX_STUDENTS; i++) {
            // Create a new student object and set its properties
            // This is a placeholder implementation and should be replaced with actual student creation logic
            Student student = new Student();
            student.setId(i);
            student.setName("Student" + i);
            student.setSurname("Surname" + i);
            student.setBirthDate(LocalDate.now().minusYears(20));
            student.setPhoneNumber(1234567890 + i);
            student.setPrimarySkill("Java");
            student.setCreatedDateTime(LocalDateTime.now());
            student.setUpdatedDateTime(LocalDateTime.now());

            // Save the student to the database using the repository
            studentRepository.saveStudent(student);
        }
    }


}
