package com.agenda.agenda.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Control")
public class Control implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Control")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "ID_Student", referencedColumnName = "ID_Student")
    private  Student student;

    @ManyToOne
    @JoinColumn(name = "ID_Teacher", referencedColumnName = "ID_teacher")
    private  Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "ID_Subject", referencedColumnName = "ID_Subject")
    private  Subject subject;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
