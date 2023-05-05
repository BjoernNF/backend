package de.neuefische.backend.controller;

import de.neuefische.backend.repository.BackendRepository;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import de.neuefische.backend.model.TodoModel;
import org.springframework.web.bind.annotation.*;
import de.neuefische.backend.service.BackendService;

import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@RestController
@RequestMapping("/api")
public class BackendController {
    private BackendService service;

    public BackendController(BackendService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World!";
    }

    @GetMapping("/todo")
    public List<TodoModel> getAllTodos() {
        return service.getAllTodos();
    }

    @GetMapping("/todo/{id}")
    public TodoModel getTodoById(@PathVariable String id){
        return service.getTodoById(id);
    }

    @PostMapping("/todo")
    public void postTodo(@RequestBody TodoModel model) {
        service.postTodo(model);
    }

    @PutMapping("/todo/{id}")
    public void PutTodo(@PathVariable String id, @RequestBody TodoModel model) {
        service.putTodo(id, model);
    }

    @DeleteMapping("/todo/{id}")
    public void deleteTodo(@PathVariable String id) {
        service.deleteTodo(id);
    }
}
