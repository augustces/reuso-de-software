# Atividade 05

O sistema desenvolvido é responsável pela gestão de informações de cursos de uma plataforma educacional.

## Desenvolvedores

- [Augusto Oliveira](https://github.com/augustces)

## Organização do Projeto

atividade_05/ │── backend/ # Pasta com os arquivos do backend (API) │ ├── endpoints.py # Define os endpoints da API │ ├── consumoAPI.py # Gerencia o "banco de dados" JSON │── BD.json # Arquivo JSON que armazena os cursos │── atividade05.pdf # Descrição da atividade │── cliente.py # Cliente para interagir com a API

## Execução

Para executar o projeto, primeiro execute o arquivo principal:

``` sh
uvicorn backend.endpoints:app --reload
```


Depois execute o código do cliente interagindo com o Menu via terminal:

``` sh
python cliente.py
```