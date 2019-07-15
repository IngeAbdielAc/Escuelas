package com.agenda.agenda.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Person")
//@Lombok
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Person", unique = true, nullable = false)
    private Long id;

    /*@OneToOne
    @JoinColumn(name = "ID_LOGIN", referencedColumnName = "ID_LOGIN")
    private  Login login;*/


    @Column
    private String nombre;

    @Column
    private String apellidoP;

    @Column
    private String apellidoM;

    @Column
    private Integer edad;

    @Column
    private String correo;

    @Column
    private String isS;

    @Column
    private String notas;

    @Column
    private String telefono;

    @Column
    private Integer activeimg;

    @Column
    private String password;

    @Column
    private Boolean fgTeacher;

    /*public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }*/

    public Boolean getFgTeacher() {
        return fgTeacher;
    }

    public void setFgTeacher(Boolean fgTeacher) {
        this.fgTeacher = fgTeacher;
    }

    public Integer getActiveimg() {
        return activeimg;
    }

    public void setActiveimg(Integer activeimg) {
        this.activeimg = activeimg;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIsS() {
        return isS;
    }

    public void setIsS(String isS) {
        this.isS = isS;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    /*public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }*/
}
