package com.example.BMS.Controller;

import com.example.BMS.DTO.TransactionDTO;
import com.example.BMS.Entity.Transaction;
import com.example.BMS.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/view/{id}")
    public List<TransactionDTO> view(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }
    @GetMapping("/viewAll")
    public List<TransactionDTO> viewAll() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/account/{accountId}")
    public List<TransactionDTO> getByAccount(@PathVariable Long accountId){
        return transactionService.getTransactionsByAccount(accountId);
    }
}
