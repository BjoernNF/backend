package de.neuefische.backend;

import de.neuefische.backend.model.TodoModel;
import de.neuefische.backend.model.slugStatusEnum;
import de.neuefische.backend.repository.BackendRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

import java.util.UUID;

public class RepositoryTests {

    @Test
    @DirtiesContext
    public void getAllTodos_shouldReturnEmptyList()
    {
        //GIVEN
        BackendRepository repository = new BackendRepository();

        //WHEN
        var result = repository.getAllTodos();

        //THEN
        Assertions.assertArrayEquals(new String[]{}, result.toArray());
    }

    @Test
    @DirtiesContext
    public void getAllTodos_shouldReturnListWithOneElement()
    {
        //GIVEN
        BackendRepository repository = new BackendRepository();
        var todo = new TodoModel();
        todo.setDescription("Test");
        todo.setId("1");
        todo.setStatus(slugStatusEnum.OPEN);
        repository.postTodoUUID(todo);

        //WHEN
        var result = repository.getAllTodos().get(0);

        //THEN
        Assertions.assertEquals(todo, result);
    }

    @Test
    @DirtiesContext
    public void getTodoById_shouldReturnTodo()
    {
        //GIVEN
        BackendRepository repository = new BackendRepository();
        var todo = new TodoModel();
        todo.setDescription("Test");
        todo.setId("1");
        todo.setStatus(slugStatusEnum.OPEN);
        UUID uuid = repository.postTodoUUID(todo);

        //WHEN
        var result = repository.getTodoById(uuid.toString());

        //THEN
        Assertions.assertEquals(todo, result);
    }

//    @Test
//    @DirtiesContext
//    public void getTodoById_shouldReturnNull()
//    {
//        //GIVEN
//        BackendRepository repository = new BackendRepository();
//        var todo = new TodoModel();
//        todo.setDescription("Test");
//        todo.setId("1");
//        todo.setStatus(slugStatusEnum.OPEN);
//        repository.postTodoUUID(todo);
//
//        //WHEN
//        var result = repository.getTodoById("2");
//
//        //THEN
//        Assertions.assertNull(result);
//    }

    @Test
    @DirtiesContext
    public void postTodoUUID_shouldReturnUUID()
    {
        //GIVEN
        BackendRepository repository = new BackendRepository();
        var todo = new TodoModel();
        todo.setDescription("Test");
        todo.setId("1");
        todo.setStatus(slugStatusEnum.OPEN);

        //WHEN
        var result = repository.postTodoUUID(todo);

        //THEN
        Assertions.assertNotNull(result);
    }
}
