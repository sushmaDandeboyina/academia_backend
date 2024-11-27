package com.sush.academia_iiitb.repo;

import com.sush.academia_iiitb.entity.Bills;
import com.sush.academia_iiitb.entity.StudentPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentPaymentRepo extends JpaRepository<StudentPayment, Integer> {

    @Query("SELECT sp FROM StudentPayment sp WHERE sp.student.studentId = :studentId and  sp.bill.id=:billId")
    List<StudentPayment> findpaysByIds(@Param("studentId") Integer studentId, @Param ("billId") Integer billId);

    //List<StudentPayment> findStudentPaymentBy(Integer studentId);
}

