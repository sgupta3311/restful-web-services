package com.sg.rest.webservices.restfulwebservices.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {
    private Integer Id;
    @Size(min=2,message="Name should have aleast 2 characters")
    private String name;
    @Past(message="Birthday should be in past")
    private LocalDate BirthDate;

     public User(Integer id, String name, LocalDate birthDate) {
        Id = id;
        this.name = name;
        BirthDate = birthDate;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", BirthDate=" + BirthDate +
                '}';
    }
}
