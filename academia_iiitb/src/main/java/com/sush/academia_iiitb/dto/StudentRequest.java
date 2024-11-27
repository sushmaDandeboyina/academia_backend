package com.sush.academia_iiitb.dto;

import  com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record StudentRequest(

        @NotNull(message = "Roll number is required")
        @NotEmpty(message = "Roll number cannot be empty")
        @NotBlank(message = "Roll number cannot be blank")
        @Size(max = 20, message = "Roll number must not exceed 20 characters")
        @JsonProperty("roll_number")
        String rollNumber,

        @NotNull(message = "First name is required")
        @NotEmpty(message = "First name cannot be empty")
        @NotBlank(message = "First name cannot be blank")
        @JsonProperty("first_name")
        String firstName,

        @JsonProperty("last_name")
        String lastName,

        @NotNull(message = "Email is required")
        @Email(message = "Email must be in a valid format")
        @JsonProperty("email")
        String email,

        @JsonProperty("photograph_path")
        String photographPath,

        @DecimalMin(value = "0.0", inclusive = true, message = "CGPA cannot be less than 0.0")
        @DecimalMax(value = "10.0", inclusive = true, message = "CGPA cannot exceed 10.0")
        @JsonProperty("cgpa")
        Double cgpa,

        @Min(value = 0, message = "Total credits cannot be negative")
        @JsonProperty("total_credits")
        Integer totalCredits,

        @PositiveOrZero(message = "Graduation year must be a positive number or zero")
        @JsonProperty("graduation_year")
        Integer graduationYear,

        @JsonProperty("domain")
        Integer domain,

        @JsonProperty("specialisation_id")
        Integer specialisationId,

        @JsonProperty("placement_id")
        Integer placementId,

        @NotNull(message = "Password should be present")
        @NotEmpty(message = "Password should be present")
        @NotBlank(message = "Password should be present")
        @Size(min = 6, max = 12)
        @JsonProperty("password")
        String password
) {
}


