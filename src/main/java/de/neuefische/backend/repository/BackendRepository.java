package de.neuefische.backend.repository;

import lombok.Data;
import de.neuefische.backend.model.TodoModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Data
@Repository
public class BackendRepository {

    private final HashMap<String, TodoModel> todoModel = new HashMap<>();

    public List<TodoModel> getAllTodos() {
        List<TodoModel> list = new LinkedList<>();
        for(TodoModel model : todoModel.values()) {
            list.add(model);
        }
        return list;
    }

    public TodoModel getTodoById(String id) {
        if (todoModel.containsKey(id)) {
            return todoModel.get(id);
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found with ID: " + id);
        }
    }

    public UUID postTodoUUID(TodoModel model) {
        UUID uuid = UUID.randomUUID();
        model.setId(uuid.toString());
        todoModel.put(uuid.toString(), model);
        return uuid;
    }

    public void putTodo(String id, TodoModel model) {
        todoModel.replace(id, model);
    }

    public void deleteTodo(String id) {
        todoModel.remove(id);
    }

}
