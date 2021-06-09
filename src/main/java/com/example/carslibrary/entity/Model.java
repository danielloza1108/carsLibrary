package com.example.carslibrary.entity;

import javax.persistence.*;

@Entity
@Table(name = "model", indexes = @Index(columnList = "name"))
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    private int year_from;
    private int year_to;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_make")
    private Make make;

    public Model() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear_from() {
        return year_from;
    }

    public void setYear_from(int year_from) {
        this.year_from = year_from;
    }

    public int getYear_to() {
        return year_to;
    }

    public void setYear_to(int year_to) {
        this.year_to = year_to;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }
}
