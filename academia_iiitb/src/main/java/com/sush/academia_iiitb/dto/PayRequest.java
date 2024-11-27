package com.sush.academia_iiitb.dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter


public class PayRequest {
    private Integer studentId;
    private Integer billId;
    private double amount;
    private String description;
    private LocalDateTime paymentDate;
}
