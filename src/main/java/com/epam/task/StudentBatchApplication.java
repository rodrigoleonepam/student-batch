package com.epam.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epam.task.service.ExamService;
import com.epam.task.service.StudentService;
import com.epam.task.service.SubjectService;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class StudentBatchApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private ExamService examService;

	public static void main(String[] args) {
		SpringApplication.run(StudentBatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// This method is called after the application context is loaded
		// You can add any initialization logic here if needed
		log.info("Student Batch Application started successfully.");
		studentService.populateStudentData();
		subjectService.populateSubjectData();
		examService.populateExamData();
		log.info("Student data populated successfully.");
	}

}
