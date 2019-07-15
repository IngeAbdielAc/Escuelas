package com.agenda.agenda.domain;

import javax.persistence.*;

@Entity
@Table(name = "Login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_LOGIN", unique = true, nullable = false)
    private Long id;

    /*
    * Last access date
    *
     */
    @Column
    private String lastAccess;

    /*
    * 1- active
    * 2.- blocked
    */
    @Column
    private String status;

    /*
    * Attempts for login
     */
    @Column
    private String attempts;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(String lastAccess) {
        this.lastAccess = lastAccess;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAttempts() {
        return attempts;
    }

    public void setAttempts(String attempts) {
        this.attempts = attempts;
    }
}
