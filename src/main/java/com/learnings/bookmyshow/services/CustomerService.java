package com.learnings.bookmyshow.services;

import com.learnings.bookmyshow.dto.CustomerDTO;
import com.learnings.bookmyshow.entities.Customer;
import com.learnings.bookmyshow.entities.User;
import com.learnings.bookmyshow.exception.CustomerNotFoundException;
import com.learnings.bookmyshow.exception.InvalidCustomerException;
import com.learnings.bookmyshow.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserService userService;
    public Customer createCustomer(CustomerDTO customer) {
        Optional<Customer> existingCustomer = customerRepository.findByEmail(customer.getEmail());
        if (existingCustomer.isPresent()){
            throw new InvalidCustomerException("Customer exists with email:" + customer.getEmail());
        }
        User user = userService.createUser(customer.getUsername(),customer.getPassword());
        return customerRepository.save(
                Customer.builder()
                        .fullName(customer.getFullName())
                        .city(customer.getCity())
                        .email(customer.getEmail())
                        .phoneNumber(customer.getPhoneNumber())
                        .user(user)
                        .build());

    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public Customer getCustomerInternal(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }
}
