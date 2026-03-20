package com.example.BMS.Entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    private String accolder_name;
    private double balance;
    private String account_type;

    public Account(){}


    public Account(Long acc_id, String accolder_name, double balance, String account_type) {
        this.accountId = acc_id;
        this.accolder_name = accolder_name;
        this.balance = balance;
        this.account_type = account_type;
    }


    public Long getAcc_id() {
        return accountId;
    }

    public void setAcc_id(Long acc_id) {
        this.accountId = acc_id;
    }

    public String getAccolder_name() {
        return accolder_name;
    }

    public void setAccolder_name(String accolder_name) {
        this.accolder_name = accolder_name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id")
    public Customer customer;
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @OneToMany(mappedBy = "account")
    public List<Transaction> transactions;
    public List<Transaction> getTransactions() {

        return transactions;
    }
    public void addTransaction(Transaction transaction) {
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        transactions.add(transaction);
    }


}
