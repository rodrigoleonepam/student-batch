package com.epam.task.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Student {
    
    private int id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private int phoneNumber;
    private String primarySkill;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;
    
}
