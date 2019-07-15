package com.agenda.agenda.request;

import io.swagger.models.auth.In;

import javax.persistence.Column;

public class PersonaRequest {

    private Long id;

    private String nombre;

    private String correo;

    private Integer edad;

    private String is;

    private String notas;

    private String telefono;

    private Integer activeimg;

    private String password;

    private Boolean teacher;

    private Boolean alumno;

    public Boolean getTeacher() {
        return teacher;
    }

    public void setTeacher(Boolean teacher) {
        this.teacher = teacher;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getActiveimg() {
        return activeimg;
    }

    public void setActiveimg(Integer activeimg) {
        this.activeimg = activeimg;
    }

    public String getIs() {
        return is;
    }

    public void setIs(String is) {
        this.is = is;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getAlumno() {
        return alumno;
    }

    public void setAlumno(Boolean alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "PersonaRequest{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", edad=" + edad +
                '}';
    }
}
