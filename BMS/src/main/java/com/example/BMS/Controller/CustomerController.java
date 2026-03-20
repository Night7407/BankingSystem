package com.example.BMS.Controller;


import com.example.BMS.DTO.CustomerDTO;
import com.example.BMS.Entity.Customer;
import com.example.BMS.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @PostMapping("/create")
    public String createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
        return "success";
    }
    @GetMapping("/viewAll")
    public List<CustomerDTO> getAllCustomer(){
        return customerService.getAllCustomer();
    }

}
