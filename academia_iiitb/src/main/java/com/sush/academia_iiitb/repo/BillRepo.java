package com.sush.academia_iiitb.repo;

import com.sush.academia_iiitb.entity.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepo extends JpaRepository<Bills, Integer> {
    @Query("SELECT b FROM Bills b JOIN StudentBill sb ON b.id = sb.bill.id WHERE sb.student.studentId = :studentId")
    List<Bills> findBillsByStudentId(@Param("studentId") Integer studentId);
}
