package com.sush.academia_iiitb.controller;

import com.sush.academia_iiitb.dto.*;
import com.sush.academia_iiitb.service.BillService;
import com.sush.academia_iiitb.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/academia/v1/student")


public class BillController {
    private final BillService billService;

    @GetMapping("/bills")
    public ResponseEntity<List<BillsResponse>> getBills(@RequestBody @Valid BillsRequest billsRequest) {
        Integer studentId = billsRequest.getStudentId();

        // Logic to handle the request
        return ResponseEntity.ok(billService.getBillsByStudentId(studentId));
    }

    @GetMapping("/bills/payments")
    public ResponseEntity<List<PaymentResponse>> getBillsPayments(@RequestBody @Valid PaymentRequest paymentRequest) {
        Integer studentId = paymentRequest.getStudentId();
        Integer billId = paymentRequest.getBillId();
        return ResponseEntity.ok(billService.getpaysByStudentId(studentId, billId));

    }

    @PostMapping("/bills/pay")
    public ResponseEntity<String> payBill(@RequestBody @Valid PayRequest payRequest) {
        Integer studentId = payRequest.getStudentId();
        Integer billId = payRequest.getBillId();
        Double amount = payRequest.getAmount();
        String description = payRequest.getDescription();
        LocalDateTime paymentDate = LocalDateTime.now();
        return ResponseEntity.ok(billService.paybills(studentId,billId,amount,description,paymentDate));
    }

}
