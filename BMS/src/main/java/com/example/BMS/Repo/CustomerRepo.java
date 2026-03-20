package com.example.BMS.Repo;

import com.example.BMS.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long>{

}