package com.example.entidades;

public class Consulta {
   private String data;
   private String tiragem;
   
   public Consulta(String data, String tiragem){
    this.data = data;
    this.tiragem = tiragem;
   }

   public Consulta(String stringSerializada){
      String[] partes = stringSerializada.split(",");
      this.data = partes[0];
      this.tiragem = partes[1];
   }

   public String getId(){
      return data;
   }

   @Override
   public String toString(){
    return "Data agendada: " + this.data +  " - Tipo da Tiragem: " + this.tiragem;
   }
   
   public String serializacao(){
      return data+","+tiragem;
   }
}
