package com.example.BMS.Service;


import com.example.BMS.DTO.CustomerDTO;
import com.example.BMS.Entity.Customer;
import com.example.BMS.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    AccountService accountService;

    public CustomerDTO convertToDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();

        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setPhoneNumber(customer.getPhoneNumber());
        dto.setAddress(customer.getAddress());

        dto.setAccounts(
                customer.getAccounts()
                        .stream()
                        .map(accountService::convertToDTO)
                        .toList()
        );

        return dto;
    }

    public String createCustomer(Customer customer){
        customerRepo.save(customer);
        return "Customer Created";
    }

    public List<CustomerDTO> getAllCustomer(){
        return customerRepo.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }
}
