package de.neuefische.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTests {

    @Autowired
    MockMvc mockMvc;
    @Test
    @DirtiesContext
    public void getAllTodos_thenReturnEmptyOrderList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

//    @Test
//    @DirtiesContext
//    public void getTodoById_thenReturnTodo() throws Exception {
//        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/todo")
//                        .contentType("application/json")
//                        .content("""
//                        {
//                            "description" : "Hello",
//                            "status" : "DONE"
//                        }
//                        """))
//                .andExpect(status().isOk());
//        MvcResult mvcResult = result.andReturn();
//        String content = mvcResult.getResponse().getContentAsString();
//
//        // https://www.baeldung.com/jackson-object-mapper-tutorial
//        // serialize java object to json
//        ObjectMapper objectMapper = new ObjectMapper();
//        TodoModel model = objectMapper.readValue(content, TodoModel.class);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo/" + model.getId()))
//                .andExpect(status().isOk())
//                .andExpect(content().json("""
//                        {
//                            "description" : "Hello",
//                            "status" : "DONE"
//                        }
//                        """))
//                .andExpect(jsonPath("$.id").value(model.getId()));
//    }

    @Test
    @DirtiesContext
    public void whenGetTodoByIdWithInvalidId_thenThrowResponseStatusException_andStatus404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo/notvalidid"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DirtiesContext
    // TODO: implement this test
    public void updateTodo() {

    }

    @Test
    @DirtiesContext
    public void addTodoWithId_then200OK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/todo")
                .contentType("application/json")
                .content("""
                        {
                            "id" : "1534",
                            "description" : "Hello",
                            "status" : "DONE"
                        }
                """))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                        {
                            "description" : "Hello",
                            "status" : "DONE"
                        }
                        ]
                        """))
                .andExpect(jsonPath("$[0].id").isNotEmpty());
    }


}
