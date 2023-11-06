package com.learnings.bookmyshow.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer extends Auditable{

    private String fullName;
    private String city;
    private String phoneNumber;
    private String email;
    @OneToOne
    private User user;
}
