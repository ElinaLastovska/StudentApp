package com.example.demo.repository;

import com.example.demo.domain.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
