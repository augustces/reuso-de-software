# Atividade 05

O sistema desenvolvido é responsável pela gestão de informações de cursos de uma plataforma educacional.

## Desenvolvedores

- [Augusto Oliveira](https://github.com/augustces)

## Organização do Projeto

- `backend/endpoints.py`: Define os endpoints da API que serão utilizados pelo cliente.
- `backend/consumoAPI.py`: Gerencia o acesso e a manipulação do arquivo `BD.json`.
- `BD.json`: Arquivo que armazena os dados dos cursos.
- `atividade05.pdf`: Documento PDF com a descrição da atividade.
- `cliente.py`: Script utilizado para interagir com a API definida no backend.

## Execução

Para executar o projeto, primeiro execute o arquivo principal:

``` sh
uvicorn backend.endpoints:app --reload
```


Depois execute o código do cliente interagindo com o Menu via terminal:

``` sh
python cliente.py
```