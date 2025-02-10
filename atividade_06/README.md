# Atividade 06

Foi desenvolvido um framework que permite o cadastro, consulta, atualização e remoção de entidades genéricas. O exemplo de sistema de teste presente no arquivo "Main.java" faz referência a um Registro de Consultas de Tarot, onde é possível realizar o CRUD de Consulentes (os clientes) e as consultas. 

- A entidade Consulente possui como atributos CPF, nome e data de nascimento, sendo o CPF o identificador único - da entidade.
A entidade Consulta possui data e tiragem como atributos, sendo a data o identificador único da entidade e o atributo tiragem refere-se ao tipo de tiragem realizada.

## Desenvolvedores
- [Augusto Oliveira](https://github.com/augustces)

## Organização do Projeto

- Pastas:
    - Arquivos - Contém os arquivos de leitura e escrita
    - Base - Contém as classes básicas do sistema e a interface dessas classes.
    - Entidades - Contém as classes de cada entidade utilizada nesse sistema.
- Arquivos:
    - consulentes.txt - Arquivo de leitura e escrita para a entidade Consulente
    - consultas.txt - Arquivo de leitura e escrita para a entidade Consulta
    - CrudRepository.java - Código da interface do CRUD do sistema  
    - InFileRepository.java - Código do CRUD utilizando um arquivo de texto para a leitura e escrita dos dados
    - InMemoryRepository.java - Código do CRUD utilizando uma estrutura de dados para o armazenamento dos dados
    - Consulta.java - Código da classe Consulta
    - Consulente.java - Código da classe Consulente
    - Main.java - Código principal onde é testado o framework

## Execução

- É necessário Java 17 ou superior instalado na sua máquina.

### Execução do Arquivo .jar
Para executar o arquivo .jar gerado, siga as etapas abaixo:

1. Abra o terminal ou prompt de comando.
2. Navegue até o diretório onde o arquivo .jar está localizado (pasta target, dentro de src).
3. Execute o comando a seguir: 
``` sh
java -jar target/framework-1.0-SNAPSHOT.jar

```
4. O sistema será executado em seguida, onde será possível ver as iterações feitas a partir dos prints via terminal (Não foi feito um sistema interativo, mas sim uma aplicação manual do CRUD com os logs sendo aprensentados via terminal).

