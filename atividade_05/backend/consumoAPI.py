import json

BD = "BD.json"

# Carregar cursos do arquivo JSON
def carregar_cursos():
    try:
        with open(BD, "r", encoding="utf-8") as file:
            return json.load(file)
    except (FileNotFoundError, json.JSONDecodeError):
        return {}

# Salvar cursos no arquivo JSON
def salvar_cursos(cursos):
    with open(BD, "w", encoding="utf-8") as file:
        json.dump(cursos, file, indent=4, ensure_ascii=False)
