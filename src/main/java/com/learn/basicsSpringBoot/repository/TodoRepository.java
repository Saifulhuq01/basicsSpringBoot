package com.learn.basicsSpringBoot.repository;


import com.learn.basicsSpringBoot.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

//CURD
public interface TodoRepository extends JpaRepository<Todo, Long> {

}

