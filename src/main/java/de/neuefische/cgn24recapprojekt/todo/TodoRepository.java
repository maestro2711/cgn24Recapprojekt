package de.neuefische.cgn24recapprojekt.todo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository <Todo,String>{
}
