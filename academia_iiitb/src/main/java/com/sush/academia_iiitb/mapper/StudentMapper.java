package com.sush.academia_iiitb.mapper;

import com.sush.academia_iiitb.dto.LoginRequest;
import com.sush.academia_iiitb.dto.StudentRequest;
import com.sush.academia_iiitb.entity.Register;
import com.sush.academia_iiitb.entity.Students;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

        public Students toStudentEntity(StudentRequest request) {
            return Students.builder()
                    .rollNumber(request.rollNumber())
                    .firstName(request.firstName())
                    .lastName(request.lastName())
                    .email(request.email())
                    .build();
        }

    public Register toRegisterEntity(Students student, String password) {
        Register register = new Register();
        register.setEmail(student.getEmail());
        register.setPassword(password);
        register.setStudentId(student.getStudentId());// Set the `Student` entity
        System.out.println("vere-----------------"+student.getStudentId());
        return register;
    }

    public Register loginEntity(LoginRequest request) {
        return Register.builder()
                .email(request.email())
                .password(request.password())
                .build();
    }

}

