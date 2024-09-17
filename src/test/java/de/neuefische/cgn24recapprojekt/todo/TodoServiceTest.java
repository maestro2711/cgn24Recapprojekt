package de.neuefische.cgn24recapprojekt.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TodoServiceTest {
    private final TodoRepository todoRepository = mock(TodoRepository.class);
    private final TodoService todoService = new TodoService(todoRepository);


    @Test
    void findAllTodo() {
        //GIVEN
        Todo todo = new Todo("1","Let Do","Open");
        todoRepository.save(todo);
        List<Todo> expected = List.of(todo);

        when(todoRepository.findAll()).thenReturn(expected);

        List<Todo> actual= todoService.findAllTodo();

        assertEquals(expected,actual);
    }

    @Test
    void saveTodo() {
        Todo todo = new Todo("1","Let Do","Open");
        todoRepository.save(todo);
        //List<Todo> expected= List.of(todo);

        when(todoRepository.save(any(Todo.class))).thenReturn(todo);

        Todo actual=todoService.saveTodo(todo);
        assertEquals(todo,actual);


    }

    @Test
    void updateTodo() {
    }

    @Test
    void findTodoById() {
        String id="1";
        Todo todo=new Todo("1","Marke","Done");
        todoRepository.save(todo);

        when(todoRepository.findById(id)).thenReturn(Optional.of(todo));

        Todo actual=todoService.findTodoById(id);
        assertEquals(todo,actual);
    }

    @Test
    void deleteTodo() {
        String id ="1";
        Todo todo=new Todo("1","PSbuy","Doing");
        todoRepository.save(todo);

        when(todoRepository.findById(id)).thenReturn(Optional.of(todo));
        Todo actual=todoService.deleteTodo(id);
    }
}