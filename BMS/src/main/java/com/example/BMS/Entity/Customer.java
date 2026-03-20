package com.example.BMS.Entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerID;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public Customer() {
    }



    public Customer(String name, String email, String phoneNumber, String address) {

        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }



    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @OneToMany(mappedBy = "customer")
    public List<Account> Accounts;

    public List<Account> getAccounts() {
        return Accounts;
    }

    public void setAccounts(List<Account> getAccounts) {
        this.Accounts = getAccounts;
    }






}
