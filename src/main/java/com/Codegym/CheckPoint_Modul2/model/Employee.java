package com.Codegym.CheckPoint_Modul2.model;


import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long id;
    private String gen;
    private String name;
    private String gender;
    private String phoneNumber;
    private String birth;

    public Employee(String gen, String name, String gender, String phoneNumber, String birth, String email, String address, String cmnd, Category category) {
        this.gen = gen;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
        this.email = email;
        this.address = address;
        this.cmnd = cmnd;
        this.category = category;
    }

    private String email;
    private String address;
    private String cmnd;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Employee() {
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
