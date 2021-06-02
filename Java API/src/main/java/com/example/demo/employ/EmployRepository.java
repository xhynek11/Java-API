package com.example.demo.employ;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployRepository extends JpaRepository<Employ, Long> {

    @Query("SELECT s FROM Employ s WHERE s.email = ?1")
    Optional<Employ> findEmployByEmail(String email);
}
