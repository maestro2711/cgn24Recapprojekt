package de.neuefische.cgn24recapprojekt;


import com.fasterxml.jackson.databind.ObjectMapper;
import de.neuefische.cgn24recapprojekt.todo.Todo;
import de.neuefische.cgn24recapprojekt.todo.TodoRepository;
import de.neuefische.cgn24recapprojekt.todo.TodoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static java.lang.reflect.Array.get;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoIntegrationTest {


    @Autowired
    MockMvc mockMvc;

    @Autowired
    TodoRepository todoRepository;

    @DirtiesContext
    @Test

    void testGetAllCats_returnsStatus200WithOneTodo() throws Exception {
        //GIVEN
        todoRepository.save(new Todo("","Task Perform","OPEN"));

        //WHEN
        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo"))

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
[
                          {
                          "id": "",
                          "description":  "Task Perform",
                          "status":  "OPEN"
                          }
                        ]
"""));


    }





}

