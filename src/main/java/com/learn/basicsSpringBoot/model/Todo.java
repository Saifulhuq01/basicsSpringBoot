package com.learn.basicsSpringBoot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
//if value id null use @Data  or manually write getter and setter
public class Todo {
    @Id
    @GeneratedValue
    Long id;
    @NotNull
    String title;
    @NotNull
    String description;
    @NotNull
    Boolean isCompleted;

}
