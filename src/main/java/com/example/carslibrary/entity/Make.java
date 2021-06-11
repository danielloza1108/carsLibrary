package com.example.carslibrary.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Setter
@Getter
@Table(name = "make", indexes = @Index(columnList = "name"))
public class Make {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
}
