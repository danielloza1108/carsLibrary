package com.example.carslibrary.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "model", indexes = @Index(columnList = "name"))
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    private int yearFrom;
    private int yearTo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_make")
    private Make make;
}
