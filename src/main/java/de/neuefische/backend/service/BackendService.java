package de.neuefische.backend.service;

import de.neuefische.backend.model.TodoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import de.neuefische.backend.repository.BackendRepository;

import java.util.List;
import java.util.UUID;

@Service
public class BackendService {
        BackendRepository repository;

        public BackendService(BackendRepository repository) {
            this.repository = repository;
        }

        public List<TodoModel> getAllTodos() {
            return repository.getAllTodos();
        }

        public TodoModel getTodoById(String id) {
            return repository.getTodoById(id);
        }

        public UUID postTodo(TodoModel todo) {
            return repository.postTodoUUID(todo);
        }

        public void putTodo(String id, TodoModel todo) {
        repository.putTodo(id, todo);
    }

        public void deleteTodo(String id) {
            repository.deleteTodo(id);
        }

}
