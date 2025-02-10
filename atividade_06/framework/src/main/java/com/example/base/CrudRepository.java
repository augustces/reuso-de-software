package com.example.base;

import java.util.*;

public interface CrudRepository<T>{
    void save(T entity); // insere uma nova entidade no map
    T findById(int id); // encontrar entidade pelo id
    void update(T entity); // atualizar entidade
    void delete(int id); // deletar entidade pelo id
    List<T> findAll(); // retornar todas as entidades dentro do map
}


