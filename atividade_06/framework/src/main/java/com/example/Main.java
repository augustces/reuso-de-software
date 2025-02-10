package com.example;

import java.io.File;
import java.util.*;

import com.example.base.CrudRepository;
import com.example.base.InFileRepository;
import com.example.base.InMemoryRepository;
import com.example.entidades.Consulente;
import com.example.entidades.Consulta;

public class Main {
    public static void main(String[] args) {
        // Testando repositório em memória
        System.out.println("--- Testando InMemoryRepository ---");
        // Testando para a entidade Consulente
        testarRepositorioConsulente(new InMemoryRepository<Consulente>());
        // Testando para a entidade Consulta
        testarRepositorioConsulta(new InMemoryRepository<Consulta>());

        // Testando repositório em arquivo
        System.out.println("--- Testando InFileRepository ---");
        // Testando para a entidade Consulente
        String path = "src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"example"+File.separator+"arquivos";
        testarRepositorioConsulente(new InFileRepository<Consulente>(path+File.separator+"consulentes.txt", Consulente.class));
        // Testando para a entidade Consulta
        testarRepositorioConsulta(new InFileRepository<Consulta>(path+File.separator+"consultas.txt", Consulta.class));
    }

    // Método para testar o reposítório para a entidade Consulente
    private static void testarRepositorioConsulente(CrudRepository<Consulente> repo) {
        System.out.println("--Testando a entidade Consulente--");
        // Objetos para teste
        Consulente c1 = new Consulente("Maria Fernanda", "12/07/1982", "08976543212");
        Consulente c2 = new Consulente("João Carlos", "04/03/1997", "12345678901");

        // Inserção dos objetos
        repo.save(c1);
        repo.save(c2);

        // Consulta objeto de ID = 0
        System.out.println("Objeto de ID = 0:");
        repo.findById(0);

        // Listando objetos inseridos
        listagemConsulente(repo); 

        // Atualização de objeto
        Consulente newC = new Consulente("Maria Fabiana", "13/07/1982", "08976543212");
        repo.update(newC);

        // Lista após atualização
        listagemConsulente(repo); 

        // Remoção de objeto
        repo.delete(1);

        // Lista após remoção
        listagemConsulente(repo); 
        System.out.println("");
    }

    private static void testarRepositorioConsulta(CrudRepository<Consulta> repo) {
        System.out.println("--Testando a entidade Consulta--");
        // Objetos para teste
        Consulta c1 = new Consulta("17/02/2025", "Cruz celta");
        Consulta c2 = new Consulta("23/02/2025", "Pata de gato");
        Consulta c3 = new Consulta("27/02/2025", "Aconselhamento");

        // Inserção dos objetos
        repo.save(c1);
        repo.save(c2);
        repo.save(c3);

        // Consulta objeto de ID = 1
        System.out.println("Objeto de ID = 1:");
        repo.findById(1);

        // Listagem dos objetos
        listagemConsulta(repo); 

        // Atualização de objeto
        Consulta newC = new Consulta("27/02/2025", "Pata de gato");
        repo.update(newC);

        //  Listagem após atualização
        listagemConsulta(repo);

        // Remoção de um objeto
        repo.delete(2);
       
        //  Listagem após remoção
        listagemConsulta(repo);
        System.out.println("");
    }

    private static void listagemConsulente(CrudRepository<Consulente> repo){
        int it = 0; // iterador
        List<Consulente> consultas = repo.findAll();
        
        if (consultas.isEmpty()) {
            System.out.println("Não há registros disponíveis.");
        }
        else
            System.out.println("Lista de entidades disponíveis:");
        for (Consulente entry : consultas) {
            System.out.println(it + ". "+ entry);
            it++;
        }
    }

    private static void listagemConsulta(CrudRepository<Consulta> repo){
        int it = 0; // iterador
        List<Consulta> consultas = repo.findAll(); 
        if (consultas.isEmpty()) {
            System.out.println("Não há registros disponíveis.");
        }
        else
            System.out.println("Lista de entidades disponíveis:");
        for (Consulta entry : consultas) {
            System.out.println(it + ". "+ entry);
            it++;
        }
    }
}
