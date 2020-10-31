package academy.learnprogramming.service;

import academy.learnprogramming.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional // Access and update data on resources
public class TodoService {

    @PersistenceContext // Injects the EntityManager
    EntityManager entityManager; // Actions on entity object: persist, merge, find, createQuery, refresh, clear, contains, detach

    public Todo createTodo(Todo todo) {
        // Persist into DB
        entityManager.persist(todo);
        return todo;
    }

    public Todo updateTodo(Todo todo) {
        entityManager.merge(todo);
        return todo;
    }

    public Todo findTodoById(Long id) {
        return entityManager.find(Todo.class, id);
    }

    public List<Todo> getTodos() {
        return entityManager.createQuery("SELECT t from Todo t", Todo.class).getResultList();
    }
}
