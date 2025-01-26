# Atividade 05

O sistema desenvolvido é responsável pela gestão de informações de cursos de uma plataforma educacional.

## Desenvolvedores

- [Augusto Oliveira](https://github.com/augustces)

## Organização do Projeto

atividade_05/
│── backend/

│   │── endpoints.py  # Arquivo principal que inicia a API e define os endpoints

│   │── consumoAPI.py  # Arquivo que gerencia o "banco de dados" JSON

│── BD.json  # Arquivo com os cursos

│── atividade05.pdf # Descrição do projeto

│── cliente.py # Arquivo do cliente para interagir com a API

## Execução

Para executar o projeto, primeiro execute o arquivo principal:
    -  uvicorn backend.endpoints:app --reload

Depois execute o código do cliente interagindo com o Menu via terminal.
