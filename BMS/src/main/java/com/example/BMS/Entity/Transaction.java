package com.example.BMS.Entity;


import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trasnactionID;

    private double amount;
    private String transactiontype;
    private LocalDateTime date;

    public Transaction() {

    }

    public Transaction(Long trasnactionID, double amount, String transactiontype, LocalDateTime date) {
        this.trasnactionID = trasnactionID;

        this.amount = amount;
        this.transactiontype = transactiontype;
        this.date = date;
    }

    public Long getTrasnactionID() {
        return trasnactionID;
    }

    public void setTrasnactionID(Long trasnactionID) {
        this.trasnactionID = trasnactionID;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }




}
