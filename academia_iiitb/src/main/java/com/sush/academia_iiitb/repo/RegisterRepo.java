package com.sush.academia_iiitb.repo;

import com.sush.academia_iiitb.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepo extends JpaRepository<Register, String> {
    Register findByEmail(String email);
}

