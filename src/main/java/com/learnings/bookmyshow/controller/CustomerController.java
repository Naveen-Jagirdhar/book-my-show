package com.learnings.bookmyshow.controller;

import com.learnings.bookmyshow.dto.CustomerDTO;
import com.learnings.bookmyshow.entities.Customer;
import com.learnings.bookmyshow.exception.InvalidCustomerException;
import com.learnings.bookmyshow.services.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomer(id));
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid CustomerDTO customer){
        validate(customer);
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    private void validate(CustomerDTO customer) {
        if (customer.getEmail() == null){
            throw new InvalidCustomerException("Email is mandatory");
        }
    }
}
