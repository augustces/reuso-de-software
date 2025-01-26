from fastapi import FastAPI, HTTPException
from backend.consumoAPI import carregar_cursos, salvar_cursos

app = FastAPI()
cursos = carregar_cursos()  # Carregar cursos na inicialização

# Listar todos os cursos
@app.get("/cursos")
def listar_cursos():
    return cursos

# Listar os detalhes de um curso específico
@app.get("/cursos/{id}")
def listar_curso(id: str):
    if id not in cursos:
        raise HTTPException(status_code=404, detail="Curso não encontrado")
    return cursos[id]

# Criar um novo curso
@app.post("/cursos")
def criar_curso(id: str, titulo: str, descricao: str, carga_horaria: int):
    if id in cursos:
        raise HTTPException(status_code=400, detail="ID já existe")
    cursos[id] = {"titulo": titulo, 
                  "descricao": descricao, 
                  "carga_horaria": carga_horaria}
    salvar_cursos(cursos)
    return {"mensagem": "Curso criado com sucesso"}

# Atualizar um curso existente
@app.put("/cursos/{id}")
def atualizar_curso(id: str, titulo: str = None, descricao: str = None, carga_horaria: int = None):
    if id not in cursos:
        raise HTTPException(status_code=404, detail="Curso não encontrado")
    if titulo:
        cursos[id]["titulo"] = titulo
    if descricao:
        cursos[id]["descricao"] = descricao
    if carga_horaria:
        cursos[id]["carga_horaria"] = carga_horaria
    salvar_cursos(cursos)
    return {"mensagem": "Curso atualizado com sucesso"}

# Excluir um curso
@app.delete("/cursos/{id}")
def excluir_curso(id: str):
    if id not in cursos:
        raise HTTPException(status_code=404, detail="Curso não encontrado")
    del cursos[id]
    salvar_cursos(cursos)
    return {"mensagem": "Curso removido com sucesso"}
