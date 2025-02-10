package com.example.base;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class InFileRepository<T> implements CrudRepository<T> {
    private String filename;
    private List<T> consultas = new ArrayList<>();
    private Class<T> entityClass; // Facilita a criação de novas entidades

    public InFileRepository(String filename, Class<T> entityClass) {
        this.filename = filename;
        this.entityClass = entityClass; 
    }

    // Salva a nova entidade na lista e a escreve no arquivo
    @Override
    public void save(T entity) {
        consultas.add(entity);
        System.out.println("Entidade inserida com sucesso!");
        writeToFile(); // Apenas adiciona a nova entidade ao arquivo
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
                    writeToFile();
                    System.out.println("Entidade atualizada com sucesso!");
                    return;
                }
            }
            throw new NoSuchElementException("Entidade com Id não encontrada.");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar entidade: " + e.getMessage());
        }
        
    }
    
    // Deleta as entidades pelo ID na lista e atualiza o arquivo
    @Override
    public void delete(int id) {
        if (consultas.size() > id && id >= 0){
            consultas.remove(id);
            writeToFile();
            System.out.println("Entidade deletada com sucesso!");
            return;
        }
        throw new NoSuchElementException("Entidade com Id " + id + " não encontrada.");
    }

    // Obtem todas as entidades
    @Override
    public List<T> findAll() {
        File file = new File(filename);
        List<T> entidades = new ArrayList<>();

        if (!file.exists()) {
            return entidades;  // Retorna lista vazia se o arquivo não existe
        }
        // Faz a leitura do arquivo para reconhecer todos os dados inseridos
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {  // Lê linha por linha
                try {
                    // Usa reflexão para chamar o construtor que recebe uma String
                    T entity = entityClass.getConstructor(String.class).newInstance(line);
                    entidades.add(entity);  // Adiciona a entidade à lista
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    System.out.println("Erro ao instanciar entidade: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return entidades;  // Retorna a lista de entidades
    }

    // Escreve no arquivo a cada alteração
    private void writeToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))) { // Sobrescreve o arquivo
            // Escreve no arquivo para cada entidade presente na lista de entidades
            for (T entity : consultas) {
                // Chama o método para serializar a entidade, facilitando a escrita e a leitura
                Method serializacaoMethod = entity.getClass().getMethod("serializacao");
                bw.write(String.valueOf(serializacaoMethod.invoke(entity))); // Converte  para String
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo.", e);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao chamar método de serialização.", e);
        }
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
