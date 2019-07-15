package com.agenda.agenda.response;

public class LoginResponse {

    private String status;
    private Long idTeacher;
    private Boolean teacher;

    public Boolean getTeacher() {
        return teacher;
    }

    public void setTeacher(Boolean teacher) {
        this.teacher = teacher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Long idTeacher) {
        this.idTeacher = idTeacher;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "status='" + status + '\'' +
                ", idTeacher=" + idTeacher +
                ", teacher=" + teacher +
                '}';
    }
}
