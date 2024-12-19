package com.quangbach1709.globits_rest_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "is_active", nullable = false)
    private final boolean isActive = true;

    @OneToOne(cascade = CascadeType.ALL) //dung de tao ra 1 quan he 1-1 giua 2 bang user va person
    @JoinColumn(name = "person_id", referencedColumnName = "id")//dung de chi ra khoa ngoai cua bang user
    private Person person;

    public User() {
    }


    public User(Long id, String email, String password, Person person) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean setActive(boolean isActive) {
        return isActive;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
