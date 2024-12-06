package com.quangbach1709.globits_rest_api.model;

import jakarta.persistence.*;

@Entity // Dung de tao bang trong database
@Table(name = "countries") // Dung de dat ten bang trong database

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Dung de tu dong tang gia tri cua id
    private int id;

    @Column(name = "name") // Dung de dat ten cot trong bang
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    public Country() {
    }

    public Country(int id, String name, String code, String description) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
