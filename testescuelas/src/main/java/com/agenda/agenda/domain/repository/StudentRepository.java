package com.agenda.agenda.domain.repository;

import com.agenda.agenda.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{
}
