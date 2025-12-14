package com.learn.basicsSpringBoot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//refer Builder in google
@Builder
//in postgres default have user table so we to db use this name as default called Usertable
@Table(name = "UserTable")
public class user {
    @Id
    @GeneratedValue
    Long id;
    @Email
    String email;
    String password;
}