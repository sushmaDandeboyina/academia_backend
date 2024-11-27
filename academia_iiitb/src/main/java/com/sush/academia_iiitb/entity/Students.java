package com.sush.academia_iiitb.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")

public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(unique = true, nullable = false, length = 20)
    private String rollNumber;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(length = 100)
    private String lastName;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    private String photographPath;

//    @Column(columnDefinition = "DECIMAL(3,2) DEFAULT 0.0")
    private Double cgpa = 0.0;

    private Integer totalCredits = 0;

    private Integer graduationYear;
    private Integer domain;
    private Integer specialisationId;
    private Integer placementId;

    // Getters and Setters
}
