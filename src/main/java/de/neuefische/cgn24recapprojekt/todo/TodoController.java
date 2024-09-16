package de.neuefische.cgn24recapprojekt.todo;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping

    public List<Todo>getAllTodo(){
        return todoService.findAllTodo();
    }


    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable String id){
        return todoService.findTodoById(id);
    }

    @PostMapping

    public Todo createTodo(@RequestBody Todo todo){
        return todoService.saveTodo(todo);
    }


   @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable String id){
         todoService.deleteTodo(id);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@RequestBody UpdateTodo todo){
        Todo todoToUpdate = new Todo(UUID.randomUUID().toString(),todo.description(),todo.status());
        return todoService.updateTodo(todo);
    }

}
