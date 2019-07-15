package com.agenda.agenda.domain.repository;

import com.agenda.agenda.domain.Control;
import com.agenda.agenda.request.StudentsRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ControlRepository extends JpaRepository<Control,Long> {
    List<Control> findByTeacherId(Long studentsRequest);
}
