package com.learn.basicsSpringBoot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
//if value id null use @Data  or manually write getter and setter
public class Todo {
    @Id
    @GeneratedValue
    Long id;
    @NotNull
    @NotBlank
    String title;
    @NotNull
    @NotBlank
    String description;
    Boolean isCompleted;

    @Email
    String email;

}
