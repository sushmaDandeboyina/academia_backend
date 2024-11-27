package com.sush.academia_iiitb.service;

import com.sush.academia_iiitb.dto.*;
import com.sush.academia_iiitb.entity.Bills;
import com.sush.academia_iiitb.entity.Register;
import com.sush.academia_iiitb.entity.StudentPayment;
import com.sush.academia_iiitb.entity.Students;

import com.sush.academia_iiitb.helper.EncryptionService;
import com.sush.academia_iiitb.helper.JWTHelper;
import com.sush.academia_iiitb.mapper.BillMapper;
import com.sush.academia_iiitb.mapper.PaysMapper;
import com.sush.academia_iiitb.mapper.StudentMapper;
import com.sush.academia_iiitb.repo.BillRepo;
import com.sush.academia_iiitb.repo.RegisterRepo;
import com.sush.academia_iiitb.repo.StudentPaymentRepo;
import com.sush.academia_iiitb.repo.StudentRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo repo; // Dependency injection
    private final RegisterRepo rrepo;
    private final StudentMapper mapper;

    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;


    public LoginResponse login(@Valid LoginRequest request) {
        Register register = mapper.loginEntity(request);
        String email = register.getEmail();
        String password = register.getPassword();
        Register r = rrepo.findByEmail(email);
        if(!encryptionService.validates(password, r.getPassword())) {
            String token = "";
            int studentId = 0;
            return new LoginResponse("Logged in successful", token, studentId);

        }
        String token = jwtHelper.generateToken(request.email());

        // Fetch student ID (assuming Register entity has a studentId field)
        int studentId = r.getStudentId();  // Replace with the actual method to get student ID

        return new LoginResponse("Logged in successful", token, studentId);
    }

    public String createStudent(StudentRequest request) {
        // Convert StudentRequest to Student and Register entities
        Students student = mapper.toStudentEntity(request);
        repo.save(student);
        System.out.println("id======"+student.getRollNumber());
        Students stud =repo.findByRollNumber(student.getRollNumber());
        System.out.println("id======"+stud.getStudentId());
        Register register = mapper.toRegisterEntity(student, request.password());

        // Encrypt the password before saving
        register.setPassword(encryptionService.encode(register.getPassword()));

        // Save student and register in respective repositories

        System.out.println(register.getStudentId());
        rrepo.save(register);

        return "Created";
    }



}




