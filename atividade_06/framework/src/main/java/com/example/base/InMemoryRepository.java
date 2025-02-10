package com.example.base;

import java.lang.reflect.Method;
import java.util.*;

public class InMemoryRepository<T> implements CrudRepository<T> {
    private List<T> consultas = new ArrayList<>();

    // Salva a nova entidade na lista
    @Override
    public void save(T entity) {
        consultas.add(entity);
        System.out.println("Entidade inserida com sucesso!");
    }

    // encontra a entidade pelo id
    @Override
    public T findById(int id) {
        if (consultas.size() > id && id >= 0){
            return consultas.get(id);
        }
        throw new NoSuchElementException("Entidade com Id " + id + " não encontrada.");
    }

    // Obtem a entidade a ser modifica pelo identificador unico (ID) e substitui a entidade
    @Override
        public void update(T entity) {
        try {
            for (int i = 0; i < consultas.size(); i++) {
                if (getId(consultas.get(i)) == getId(entity)) {
                    consultas.set(i, entity);
                    System.out.println("Entidade atualizada com sucesso!");
                    return;
                }
            }
            throw new NoSuchElementException("Entidade com Id não encontrada.");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar entidade: " + e.getMessage());
        }
    }
    // Deleta as entidades pelo ID na lista
    @Override
    public void delete(int id) {
        if (consultas.size() > id && id >= 0){
            consultas.remove(id);
            System.out.println("Entidade deletada com sucesso!");
            return;
        }
        throw new NoSuchElementException("Entidade com Id " + id + " não encontrada.");
    }

    // Obtem todas as entidades
    @Override
    public List<T> findAll() {
        return consultas;
    }
    
    // Buscar o identificador único de cada entidade
    private Object getId(T entity) {
        try {
            // Busca o método para obter o id e depois invoca esse metodo na entidade passada
            Method getIdMethod = entity.getClass().getMethod("getId");
            return getIdMethod.invoke(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao acessar ID da entidade.", e);
        }
    }
}
