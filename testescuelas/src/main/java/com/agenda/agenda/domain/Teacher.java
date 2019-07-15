package com.agenda.agenda.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Teacher")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Teacher", unique = true, nullable = false)
    private Long id;

   /* @ManyToOne
    @JoinColumn(name = "ID_STUDENT", referencedColumnName = "ID_STUDENT")
    private Student student;
*/
    @ManyToOne
    @JoinColumn(name = "ID_Subject", referencedColumnName = "ID_Subject")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "ID_Attendance", referencedColumnName = "ID_Attendance")
    private Attendance attendance;

    @ManyToOne
    @JoinColumn(name = "ID_STUDENT", referencedColumnName = "ID_STUDENT")
    private Student student;

    @Column
    private String teacherName;

    @Column
    private String teacherApP;

    @Column
    private String teacherApM;

    @Column
    private Integer teacherAge;

    @Column
    private String teacherMail;

    @Column
    private String passwordTeacher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherApP() {
        return teacherApP;
    }

    public void setTeacherApP(String teacherApP) {
        this.teacherApP = teacherApP;
    }

    public String getTeacherApM() {
        return teacherApM;
    }

    public void setTeacherApM(String teacherApM) {
        this.teacherApM = teacherApM;
    }

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getTeacherMail() {
        return teacherMail;
    }

    public void setTeacherMail(String teacherMail) {
        this.teacherMail = teacherMail;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getPasswordTeacher() {
        return passwordTeacher;
    }

    public void setPasswordTeacher(String passwordTeacher) {
        this.passwordTeacher = passwordTeacher;
    }

    /*  public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }*/
}
