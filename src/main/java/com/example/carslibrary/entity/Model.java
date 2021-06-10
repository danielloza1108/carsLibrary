package com.example.carslibrary.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "model", indexes = @Index(columnList = "name"))
@Data
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
}
