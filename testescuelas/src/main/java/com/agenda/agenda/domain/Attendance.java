package com.agenda.agenda.domain;


import javax.persistence.*;

@Entity
@Table(name = "Attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Attendance", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_STUDENT", referencedColumnName = "ID_STUDENT")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "ID_Subject", referencedColumnName = "ID_Subject")
    private Subject subject;

    private  Boolean flagAttendance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Boolean getFlagAttendance() {
        return flagAttendance;
    }

    public void setFlagAttendance(Boolean flagAttendance) {
        this.flagAttendance = flagAttendance;
    }

}
