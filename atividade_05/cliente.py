import requests, json

URL = "http://127.0.0.1:8000/cursos"  # URL da API

# retorna cursos disponíveis no arquivo json
# Método GET para todos os cursos
def listar_cursos():
    response = requests.get(URL)
    # ajuda na formatação dos cursos retornados
    print(json.dumps(response.json(), indent=4, ensure_ascii=False))

# retorna um curso especificado pelo ID
# Método GET para um curso específico
def listar_curso(id):
    response = requests.get(f"{URL}/{id}")
    if response.status_code == 200:
        # ajuda na formatação dos cursos retornados
        print(json.dumps(response.json(), indent=4, ensure_ascii=False))
    else:
        print("Curso não encontrado!")

# Cria curso e adiciona no banco de dados
# Método POST
def criar_curso(id, titulo, descricao, carga_horaria):
    dados = {
        "id": id,
        "titulo": titulo,
        "descricao": descricao,
        "carga_horaria": carga_horaria
    }
    response = requests.post(URL, params=dados)
    print(response.json())

# Atualiza os dados de um curso
# Método PUT
def atualizar_curso(id, titulo=None, descricao=None, carga_horaria=None):
    dados = {}
    if titulo:
        dados["titulo"] = titulo
    if descricao:
        dados["descricao"] = descricao
    if carga_horaria:
        dados["carga_horaria"] = carga_horaria

    response = requests.put(f"{URL}/{id}", params=dados)
    print(response.json())

# Deleta um curso do banco de dados
# Método DELETE
def excluir_curso(id):
    response = requests.delete(f"{URL}/{id}")
    print(response.json())

# Menu para testar as funcionalidades
if __name__ == "__main__":
    while True:
        print("\n=== Gestão de Cursos ===")
        print("1. Listar cursos")
        print("2. Obter curso por ID")
        print("3. Criar curso")
        print("4. Atualizar curso")
        print("5. Excluir curso")
        print("6. Sair")
        opcao = input("Escolha uma opção: ")

        if opcao == "1":
            listar_cursos()

        elif opcao == "2":
            curso_id = input("Digite o ID do curso: ")
            listar_curso(curso_id)

        elif opcao == "3":
            curso_id = input("ID do curso: ")
            titulo = input("Título: ")
            descricao = input("Descrição: ")
            carga_horaria = int(input("Carga horária: "))
            criar_curso(curso_id, titulo, descricao, carga_horaria)

        elif opcao == "4":
            curso_id = input("ID do curso a ser atualizado: ")
            titulo = input("Novo título (deixe em branco para não alterar): ") or None
            descricao = input("Nova descrição (deixe em branco para não alterar): ") or None
            carga_horaria = input("Nova carga horária (deixe em branco para não alterar): ")
            carga_horaria = int(carga_horaria) if carga_horaria else None
            atualizar_curso(curso_id, titulo, descricao, carga_horaria)

        elif opcao == "5":
            curso_id = input("ID do curso a ser excluído: ")
            excluir_curso(curso_id)

        elif opcao == "6":
            print("Saindo do sistema...")
            break

        else:
            print("Opção inválida!")
