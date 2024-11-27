package com.sush.academia_iiitb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class BillsResponse {
    private Integer id;
    private String description;
    private Double amount;
    private LocalDateTime billDate;
    private LocalDateTime deadline;

    // Getters and setters
}

