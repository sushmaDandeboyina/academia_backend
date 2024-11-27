package com.sush.academia_iiitb.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Data
@Table(name = "register")
public class Register {

    @Id
    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 1024)
    private String password;

    @Column(name = "student_id", nullable = false) // Store only the student ID
    private Integer studentId;
}
