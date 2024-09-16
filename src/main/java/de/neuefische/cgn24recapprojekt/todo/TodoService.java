package de.neuefische.cgn24recapprojekt.todo;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@Data
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repository;

    public List<Todo>findAllTodo(){
        return repository.findAll();
    }

    public Todo saveTodo(Todo todo){
        Todo savedTodo= new Todo(UUID.randomUUID().toString(), todo.description(), todo.status());
                return repository.save(savedTodo);
    }

    public Todo updateTodo(UpdateTodo todo){
        Todo todoToUpdate = new Todo(UUID.randomUUID().toString(), todo.description(), todo.status());
            return repository.save(todoToUpdate);


    }

    public Todo findTodoById(String id){

            return repository.findById(id)
                    .orElseThrow(()->new NoSuchElementException("Element with id:" +id+ "not found"));
    }

    public void deleteTodo(String id){

            repository.deleteById(id);

    }

}
