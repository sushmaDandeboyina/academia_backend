package com.sush.academia_iiitb.repo;

import com.sush.academia_iiitb.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Students, Integer> {
    public Students findByRollNumber(String rollNumber);
}
