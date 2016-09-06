package com.heroku.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private String animal_name;
    private String name;
    private String surname;
    private String phone_number;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getAnimalName() {
        return animal_name;
    }
    
    public void setAnimalName(String animal_name) {
        this.animal_name = animal_name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPhoneNumber() {
        return phone_number;
    }
    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }
}
