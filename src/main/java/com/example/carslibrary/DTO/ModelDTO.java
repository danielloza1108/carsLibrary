package com.example.carslibrary.DTO;

public class ModelDTO {
    private String name;
    private int year_from;
    private int year_to;


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
}
