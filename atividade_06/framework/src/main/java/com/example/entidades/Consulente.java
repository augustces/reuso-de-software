package com.example.entidades;

public class Consulente {
   private String cpf;
   private String nome;
   private String dataDeNascimento;

   public Consulente(String nome, String dataDeNascimento, String cpf){
      this.nome = nome;
      this.dataDeNascimento = dataDeNascimento;
      this.cpf = cpf;
   }

   public Consulente(String stringSerializada){
      String[] partes = stringSerializada.split(",");
      this.cpf = partes[0];
      this.nome = partes[1];
      this.dataDeNascimento = partes[2];
   }

   public String getId(){
      return cpf;
   }
   
   @Override
   public String toString(){
      return "Consulente: "+ this.nome + " - Data de Nascimento: " + this.dataDeNascimento;
   }

   public String serializacao(){
      return cpf+","+nome+","+dataDeNascimento;
   }

}
