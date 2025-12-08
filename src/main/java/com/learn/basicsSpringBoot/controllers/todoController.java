package com.learn.basicsSpringBoot.controllers;

import com.learn.basicsSpringBoot.model.Todo;
import com.learn.basicsSpringBoot.services.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class todoController {

    @Autowired
    private TodoServices todoServices;

////    pathvariable
//    @GetMapping("/{id}")
//    String todopath(@PathVariable long id){
//        return  "your pathvariable id is " + id;
//    }
//
////    request param http://localhost:8080/todo?id=10
//    @GetMapping("")
//    String todorequest(@RequestParam long id){
//        return "your request id is " + id;
//    }

//    @PostMapping("/create")
//    String todocreate(@RequestBody String body ){
//        return body;
//    }

//    @PutMapping("/update/{id}")
//    String updatetodo(@PathVariable long id){
//        return  "Update api id is " + id;
//    }
//
//    @DeleteMapping("/delete/{id}")
//    String deletetodo(@PathVariable long id){
//        return  "delete api id is " + id;
//    }


//    todo aplication code start

    @PostMapping("/create")
//    http://localhost:8080/todo/create
    ResponseEntity<Todo> createUser(@RequestBody Todo todo ){
        return new ResponseEntity<>(todoServices.createTodo(todo), HttpStatus.CREATED);
    }


//    http://localhost:8080/todo/1
    @GetMapping("/{id}")
    ResponseEntity<Todo> getUserId(@PathVariable Long id){
        try{
            Todo GetTodoById = todoServices.getTodoId(id);
            return  new ResponseEntity<>(GetTodoById, HttpStatus.OK);
        }catch (RuntimeException exception){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

//    http://localhost:8080/todo
    @GetMapping()
    ResponseEntity<List<Todo>> getAllTodo(){
        return  new ResponseEntity<>(todoServices.getAllTodo(), HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<Todo> updateTodoByID( @RequestBody Todo todo){
        return  new ResponseEntity<>(todoServices.UpdateTodo(todo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteTodoById(@PathVariable long id){
        todoServices.deleteTodoById(id);
    }
}
