package com.learn.basicsSpringBoot.controllers;

import com.learn.basicsSpringBoot.model.Todo;
import com.learn.basicsSpringBoot.services.TodoServices;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@Slf4j
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

//    swagger doc check http://localhost:8080/swagger-ui/index.html
    @ApiResponses(value = {
            @ApiResponse(responseCode ="200", description = "working"),
            @ApiResponse(responseCode = "500", description = "go and check api because its 500 error")
    })
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
            log.info("Error");
            log.warn("careful");
            log.error("error with exception",exception);
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
    ResponseEntity<String> deleteTodoById(@PathVariable long id){
        todoServices.deleteTodoById(id);
        return ResponseEntity.ok("Todo deleted successfully");
    }


//    http://localhost:8080/todo/page?page=0&size=5
//    http://localhost:8080/todo/page?page=1&size=5
    @GetMapping("/page")
    ResponseEntity<Page<Todo>> getAllTodosPaged(@RequestParam int page, @RequestParam int size){
        return new ResponseEntity<>(todoServices.getAllTodoPaged(page,size), HttpStatus.OK);
    }
}
