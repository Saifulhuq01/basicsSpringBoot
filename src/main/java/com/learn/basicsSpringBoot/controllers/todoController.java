package com.learn.basicsSpringBoot.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class todoController {

//    pathvariable
    @GetMapping("/{id}")
    String todopath(@PathVariable long id){
        return  "your pathvariable id is " + id;
    }

//    request param http://localhost:8080/todo?id=10
    @GetMapping("")
    String todorequest(@RequestParam long id){
        return "your request id is " + id;
    }

    @PostMapping("/create")
    String todocreate(@RequestBody String body ){
        return body;
    }

    @PutMapping("/update/{id}")
    String updatetodo(@PathVariable long id){
        return  "Update api id is " + id;
    }

    @DeleteMapping("/delete/{id}")
    String deletetodo(@PathVariable long id){
        return  "delete api id is " + id;
    }
}
