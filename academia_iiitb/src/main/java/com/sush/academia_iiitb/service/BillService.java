package com.sush.academia_iiitb.service;

import com.sush.academia_iiitb.dto.BillsResponse;
import com.sush.academia_iiitb.dto.PaymentResponse;
import com.sush.academia_iiitb.entity.Bills;
import com.sush.academia_iiitb.entity.StudentPayment;
import com.sush.academia_iiitb.entity.Students;
import com.sush.academia_iiitb.mapper.BillMapper;
import com.sush.academia_iiitb.mapper.PaysMapper;
import com.sush.academia_iiitb.repo.BillRepo;
import com.sush.academia_iiitb.repo.StudentPaymentRepo;

import java.time.LocalDateTime;
import java.util.List;

import com.sush.academia_iiitb.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class BillService {
    private final StudentRepo repo;

    private final StudentPaymentRepo studentPaymentRepo;
    private final PaysMapper paysMapper;

    private final BillRepo billRepository;
    private final BillMapper billMapper;

    public List<BillsResponse> getBillsByStudentId(Integer studentId) {
        List<Bills> bills = billRepository.findBillsByStudentId(studentId);
        return billMapper.toDTOList(bills);
    }

    public List<PaymentResponse> getpaysByStudentId(Integer studentId, Integer billId) {
        List<StudentPayment> pays = studentPaymentRepo.findpaysByIds(studentId,billId);
        return paysMapper.toPaymentResponseList(pays);
    }

    public String paybills(Integer studentId, Integer billId, Double amount, String description, LocalDateTime paymentDate) {
        // Fetch the student entity by studentId
        Students student = repo.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + studentId));

        // Fetch the bill entity by billId
        Bills bill = billRepository.findById(billId)
                .orElseThrow(() -> new IllegalArgumentException("Bill not found with ID: " + billId));

        // Create a new StudentPayment instance
        StudentPayment studentPayment = new StudentPayment();
        studentPayment.setStudent(student); // Set the student
        studentPayment.setBill(bill); // Set the bill
        studentPayment.setAmount(amount); // Set the amount paid
        studentPayment.setDescription(description != null ? description : bill.getDescription()); // Use provided description or bill description
        studentPayment.setPaymentDate(paymentDate != null ? paymentDate : LocalDateTime.now()); // Use provided date or current timestamp

        // Save the payment
        studentPaymentRepo.save(studentPayment);

        return "Paid successfully";
    }

}
