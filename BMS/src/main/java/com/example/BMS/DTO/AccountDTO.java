package com.example.BMS.DTO;

import java.util.List;

public class AccountDTO {

    private String accolder_name;
    private double balance;
    private String account_type;

    public AccountDTO() {

    }
    public AccountDTO(String accolder_name, double balance, String account_type) {
        this.accolder_name = accolder_name;
        this.balance = balance;
        this.account_type = account_type;
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

    private List<TransactionDTO> transactions;

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDTO> transactions) {
        this.transactions = transactions;
    }
    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }




}
