package com.example.BMS.Service;

import com.example.BMS.DTO.AccountDTO;
import com.example.BMS.DTO.TransactionDTO;
import com.example.BMS.Entity.Account;
import com.example.BMS.Entity.Customer;
import com.example.BMS.Exception.AccountNotFound;
import com.example.BMS.Exception.InsufficientBalance;
import com.example.BMS.Repo.AccountRepo;
import com.example.BMS.Repo.CustomerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepo accountRepo;
    @Autowired
    TransactionService transactionService;

    @Autowired
    CustomerRepo customerRepo;

    private List<TransactionDTO> transactions;

    public AccountDTO convertToDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccolder_name(account.getAccolder_name());
        accountDTO.setBalance(account.getBalance());
        accountDTO.setAccount_type(account.getAccount_type());

        accountDTO.setTransactions(
                account.getTransactions()
                        .stream()
                        .map(transactionService::convertToDTO)
                        .toList()
        );
        return accountDTO;
    }
    public Account convertToEntity(AccountDTO accountDTO) {
        Account account = new Account();
        account.setAccolder_name(accountDTO.getAccolder_name());
        account.setBalance(accountDTO.getBalance());
        account.setAccount_type(accountDTO.getAccount_type());
        return account;
    }

    public String createAccount(AccountDTO accountDTO) {

        Customer customer = customerRepo.findById(accountDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Account account = convertToEntity(accountDTO);
        account.setCustomer(customer);
        if (customer.getAccounts() != null) {
            customer.getAccounts().add(account);
        }

        accountRepo.save(account);

        return "Account created successfully";
    }
    public String deposit(Long id,Double amount) {
        Account account = accountRepo.findById(id).orElseThrow(() -> new AccountNotFound("Account not found"));
        account.setBalance(account.getBalance() + amount);
        transactionService.createTransaction(account,amount,"Credited");
        accountRepo.save(account);
        return "Account deposited successfully";
    }
    public String withdraw(Long id,Double amount) {
        Account account = accountRepo.findById(id).orElseThrow(() -> new AccountNotFound("Account not found"));
        if(account.getBalance()<amount) {
            throw new InsufficientBalance("Insufficient Balance");
        }
        account.setBalance(account.getBalance() - amount);
        transactionService.createTransaction(account,amount,"Debited");
        accountRepo.save(account);
        return "Account withdraw successfully";
    }


    @Transactional
    public String TransferFunds(Long id,Long id1,Double amount) {
        Account account = accountRepo.findById(id).orElseThrow(() -> new AccountNotFound("Account not found"));
        Account account1 = accountRepo.findById(id1).orElseThrow(() -> new AccountNotFound("Account not found"));
        if(account.getBalance()<amount) {
            throw new InsufficientBalance("Insufficient Balance");
        }
        account.setBalance(account.getBalance() - amount);
        account1.setBalance(account1.getBalance() + amount);
        transactionService.createTransaction(account,amount,"Debited");
        transactionService.createTransaction(account1,amount,"Credited");
        accountRepo.save(account);
        accountRepo.save(account1);
        return "Account transfered successfully";
    }

    public List<AccountDTO> getAllAccounts() {
        return accountRepo.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }


}
