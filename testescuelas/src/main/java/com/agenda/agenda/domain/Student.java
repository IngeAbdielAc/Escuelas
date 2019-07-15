package com.agenda.agenda.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_STUDENT")
    private Long id;

    /*@ManyToOne
    @JoinColumn(name = "ID_teacher", referencedColumnName = "ID_teacher")
    private Teacher teacher;

    /*@ManyToOne
    @JoinColumn(name = "ID_Attendance", referencedColumnName = "ID_Attendance")
    private Attendance attendance;
*/
    @ManyToOne
    @JoinColumn(name = "ID_PERSON", referencedColumnName = "ID_PERSON")
    private  Persona persona;


    @ManyToOne
    @JoinColumn(name = "ID_Score", referencedColumnName = "ID_Score")
    private Score score;


    @Column
    private String studentName;

    @Column
    private String studentApP;

    @Column
    private String studentApM;

    @Column
    private Integer studentAge;

    @Column
    private String studentMail;

    @Column
    private Float average;

    @Column
    private String password;


/*    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
*/
    /*public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }*/

    public Float getAverage() {
        return average;
    }

    public void setAverage(Float average) {
        this.average = average;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentApP() {
        return studentApP;
    }

    public void setStudentApP(String studentApP) {
        this.studentApP = studentApP;
    }

    public String getStudentApM() {
        return studentApM;
    }

    public void setStudentApM(String studentApM) {
        this.studentApM = studentApM;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentMail() {
        return studentMail;
    }

    public void setStudentMail(String studentMail) {
        this.studentMail = studentMail;
    }

   /* public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /*public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }*/


    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }


    /*    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /*public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }*/

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
