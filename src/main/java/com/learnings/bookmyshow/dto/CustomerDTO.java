package com.learnings.bookmyshow.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerDTO {

    private String fullName;
    private String city;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;
}
