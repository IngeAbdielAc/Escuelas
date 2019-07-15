package com.agenda.agenda.domain;

import javax.persistence.*;

@Entity
@Table(name = "HomeWork")
public class HomeWork {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_HOMEWORK", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_Control", referencedColumnName = "ID_Control")
    private Control control;

    private String nameHomeWork;

    @Column
    private Float average;

    @Column
    private String descriptionHomeWork;

    @Column
    private Boolean flagOk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameHomeWork() {
        return nameHomeWork;
    }

    public void setNameHomeWork(String nameHomeWork) {
        this.nameHomeWork = nameHomeWork;
    }

    public Float getAverage() {
        return average;
    }

    public void setAverage(Float average) {
        this.average = average;
    }

    public String getDescriptionHomeWork() {
        return descriptionHomeWork;
    }

    public void setDescriptionHomeWork(String descriptionHomeWork) {
        this.descriptionHomeWork = descriptionHomeWork;
    }

    public Boolean getFlagOk() {
        return flagOk;
    }

    public void setFlagOk(Boolean flagOk) {
        this.flagOk = flagOk;
    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }
}
