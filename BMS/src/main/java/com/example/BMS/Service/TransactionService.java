package com.example.BMS.Service;

import com.example.BMS.DTO.TransactionDTO;
import com.example.BMS.Entity.Account;
import com.example.BMS.Entity.Transaction;
import com.example.BMS.Repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {


    @Autowired
    TransactionRepo transactionRepo;

    public void createTransaction(Account account, Double amount,String type) {
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setTransactiontype(type);
        transaction.setDate(LocalDateTime.now());
        transactionRepo.save(transaction);
    }

    public List<TransactionDTO> getAllTransactions() {
        return transactionRepo.findAll().stream().map(this::convertToDTO).toList();
    }

    public List<TransactionDTO> getTransactionById(Long id) {
        return  transactionRepo.findById(id).stream().map(this::convertToDTO).toList();
    }

    public TransactionDTO convertToDTO(Transaction transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setTrasnactionID(transaction.getTrasnactionID());
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setDate(transaction.getDate());
        transactionDTO.setTransactiontype(transaction.getTransactiontype());
        return transactionDTO;
    }
    public Transaction convertToEntity(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setDate(transactionDTO.getDate());
        transaction.setTransactiontype(transactionDTO.getTransactiontype());
        return transaction;
    }

    public List<TransactionDTO> getTransactionsByAccount(Long accountId) {
        return transactionRepo.findByAccountAccountId(accountId)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

}
