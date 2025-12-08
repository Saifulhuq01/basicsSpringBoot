package com.learn.basicsSpringBoot.services;

import com.learn.basicsSpringBoot.model.Todo;
import com.learn.basicsSpringBoot.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServices {

    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo todo){
        return  todoRepository.save(todo);
    }

    public Todo getTodoId(Long id){
        return  todoRepository.findById(id).orElseThrow(()-> new RuntimeException("Todo not found"));
    }

    public List<Todo> getAllTodo(){
        return todoRepository.findAll();
    }
    public Todo UpdateTodo(Todo todo){
        return todoRepository.save(todo);
    }


    public void deleteTodo(Todo todo){
        todoRepository.delete(todo);
    }


//    delete by using id
    public void deleteTodoById(Long id){
        todoRepository.delete(getTodoId(id));
    }

}
