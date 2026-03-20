package com.example.BMS.DTO;


import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.time.LocalDateTime;


public class TransactionDTO {


    private Long trasnactionID;
    private double amount;



    private String transactiontype;
    private LocalDateTime date;

    public TransactionDTO() {
    }
    public TransactionDTO(Long trasnactionID, double amount, String transactiontype, LocalDateTime date) {
        this.trasnactionID = trasnactionID;
        this.amount = amount;
        this.transactiontype = transactiontype;
        this.date = date;
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
    public Long getTrasnactionID() {
        return trasnactionID;
    }

    public void setTrasnactionID(Long trasnactionID) {
        this.trasnactionID = trasnactionID;
    }



}
