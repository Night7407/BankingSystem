package com.example.BMS.Controller;


import com.example.BMS.DTO.AccountDTO;
import com.example.BMS.Entity.Account;
import com.example.BMS.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/view")
    public List<AccountDTO> getAccounts(){
        return  accountService.getAllAccounts();
    }

    @PostMapping("/create")
    public String createAccount(@RequestBody AccountDTO account){
        accountService.createAccount(account);
        return "Account Created";
    }

    @PostMapping("/deposit/{id}/{amount}")
    public String deposit(@PathVariable long id, @PathVariable Double amount){
        accountService.deposit(id,amount);
        return "Deposited Successfully";
    }
    @PostMapping("/WithDraw/{id}/{amount}")
    public String withDraw(@PathVariable long id, @PathVariable Double amount){
        accountService.withdraw(id,amount);
        return "Withdraw Successfully";
    }
    @PostMapping("/transfer/{id1}/{id2}/{amount}")
    public String transfer(@PathVariable long id1, @PathVariable long id2, @PathVariable Double amount){
        accountService.TransferFunds(id1,id2,amount);
        return "Transfer Successfully";
    }

}
