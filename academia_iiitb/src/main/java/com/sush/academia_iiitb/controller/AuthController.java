package com.sush.academia_iiitb.controller;

import com.sush.academia_iiitb.dto.*;
import com.sush.academia_iiitb.entity.Bills;
import com.sush.academia_iiitb.service.StudentService;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/academia/v1/student")

public class AuthController {

    private final StudentService studentService;

    @PostMapping("/create_account")
    public ResponseEntity<String> createStudent(@RequestBody @Valid StudentRequest request) {
        return ResponseEntity.ok(studentService.createStudent(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok(studentService.login(request));
    }


}





