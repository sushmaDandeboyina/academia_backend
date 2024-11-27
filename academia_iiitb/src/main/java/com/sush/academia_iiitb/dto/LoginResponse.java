package com.sush.academia_iiitb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

    // Fields
    @JsonProperty("message")
    private String message;

    @JsonProperty("token")
    private String token;

    @JsonProperty("studentId")
    private int studentId;

    // Constructor
    public LoginResponse(String message, String token, int studentId) {
        this.message = message;
        this.token = token;
        this.studentId = studentId;
    }
}
