package com.sush.academia_iiitb.dto;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentResponse {
    private Integer id;
    private String description;
    private Double amount;
    private LocalDateTime paymentDate;
    // Getters and setters
}

