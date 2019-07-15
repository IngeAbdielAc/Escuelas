package com.agenda.agenda.domain.repository;

import com.agenda.agenda.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    Teacher findByTeacherNameAndPasswordTeacher(String name, String password);
}
