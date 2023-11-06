package com.learnings.bookmyshow.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name = "USERS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends Auditable{

    private String username;
    private String password;
}
