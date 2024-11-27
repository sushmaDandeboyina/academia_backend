package com.sush.academia_iiitb.mapper;

import com.sush.academia_iiitb.dto.PaymentResponse;
import com.sush.academia_iiitb.entity.StudentPayment;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaysMapper {

    public List<PaymentResponse> toPaymentResponseList(List<StudentPayment> pays) {
        return pays.stream()
                .map(this::toPaymentResponse) // Convert each StudentPayment to PaymentResponse
                .collect(Collectors.toList()); // Collect all the responses into a list
    }

    public PaymentResponse toPaymentResponse(StudentPayment studentPayment) {
        PaymentResponse response = new PaymentResponse();

        response.setId(studentPayment.getId()); // Set the payment ID
        response.setDescription(studentPayment.getDescription()); // Set the description
        response.setAmount(studentPayment.getAmount()); // Set the amount (as Double)
        response.setPaymentDate(studentPayment.getPaymentDate()); // Set the payment date (LocalDateTime)

        return response;
    }
}
