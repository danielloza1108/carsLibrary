package com.example.carslibrary.entity;

import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "make", indexes = @Index(columnList = "name"))
@Data
public class Make {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;

}
