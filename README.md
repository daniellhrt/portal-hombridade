# 🚀 Portal Hombridade

Este projeto é uma aplicação **Spring Boot** robusta, desenvolvida para gerenciar cursos, professores e alunos de forma eficiente. Mergulhe nos detalhes e descubra como ele funciona!

---

## 🛠️ Tecnologias de Ponta Utilizadas

Construído com as melhores ferramentas para garantir performance e escalabilidade:

* **Java**: ☕ A linguagem de programação principal, conhecida por sua robustez e versatilidade.
* **Spring Boot**: 🍃 O framework que acelera o desenvolvimento de aplicações Java, focado em produtividade.
* **Spring Data JPA**: 💾 Uma camada de abstração poderosa para simplificar o acesso a dados com JPA.
* **Maven**: 📦 Essencial para o gerenciamento de dependências e a automação do processo de build do projeto.
* **Swagger**: 📄 A ferramenta definitiva para documentar e visualizar suas APIs REST de forma interativa.
* **Jakarta Persistence (JPA)**: 🔗 A API padrão para mapeamento objeto-relacional (ORM), facilitando a interação com o banco de dados.

---

## 🏗️ Estrutura do Projeto: Uma Visão Detalhada

Organização clara para um desenvolvimento ágil e manutenível:

### 💼 Modelos (Models)

As entidades centrais que representam o coração do seu sistema:

* `Curso`: 📚 Representa todos os detalhes de um curso oferecido.
* `Professor`: 🧑‍🏫 Detalhes do educador responsável pelos cursos.
* `Aluno`: 🎓 Informações dos estudantes matriculados.
* `StatusCurso`: 🚥 Um `Enum` que define os diferentes estados de um curso:
  * `ABERTO`
  * `EM_ANDAMENTO`
  * `CONCLUIDO`

### 📤 DTOs (Data Transfer Objects)

Objetos específicos para otimizar a transferência de dados entre as camadas da aplicação:

* `DadosCadastroCursoDTO`: ➕ Para a criação de novos cursos.
* `DadosAtualizadoDetalhadoCursoDTO`: 📝 Para a atualização e visualização detalhada de um curso.
* `DadosEncerramentoCursoDTO`: 🛑 Para marcar um curso como concluído.
* `DadosInicioCursoDTO`: ▶️ Para iniciar um curso, mudando seu status.
* `DadosListagemCursoDTO`: 📜 Para a exibição simplificada de listas de cursos.

### 🗄️ Repositórios (Repositories)

A camada de persistência, responsável pela comunicação com o banco de dados:

* `CursoRepository`: Uma interface que estende `JpaRepository`, fornecendo operações CRUD e consultas personalizadas para a entidade `Curso`.

### ⚙️ Serviços (Services)

Onde a lógica de negócios ganha vida:

* `CursoService`: Contém toda a lógica de negócios relacionada às operações dos cursos, garantindo a integridade e as regras de negócio.

### 🌐 Controladores (Controllers)

Os "porteiros" da sua API, definindo os endpoints para interagir com a aplicação:

* `CursoController`: Gerencia todas as requisições HTTP relacionadas aos cursos, expondo os endpoints da API REST.

---

## 🚀 Endpoints da API: Como Interagir com o Sistema

Confira os principais pontos de acesso da sua API:

### ➕ Criar Curso

Crie um novo curso com facilidade!

* **Endpoint**: `POST /api/cursos`
* **Descrição**: Cria um novo curso com os dados fornecidos.
* **Request Body**:
    ```json
    {
      "nome": "Homem ao máximo",
      "descricao": "Curso para homens que desejam ser mais parecidos com Jesus",
      "professorId": 1
    }
    ```
* **Response Body**:
    ```json
    {
      "id": 1,
      "nome": "Homem ao máximo",
      "descricao": "Curso para homens que desejam ser mais parecidos com Jesus",
      "status": "ABERTO",
      "professor": {
          "id": 1,
          "nome": "João da Silva"
      }
    }
    ```

---

### 📋 Listar Cursos

Obtenha uma lista completa de todos os cursos ativos!

* **Endpoint**: `GET /api/cursos`
* **Descrição**: Lista todos os cursos ativos com suporte a paginação.
* **Response Body**:
    ```json
    {
    "content": [
        {
          "id": 1,
          "nome": "Homem ao máximo",
          "descricao": "Curso para homens que desejam ser mais parecidos com Jesus",
          "status": "ABERTO",
          "professor": {
            "id": 1,
            "nome": "João da Silva"
          },
          "alunos": []
        }
    ],
    "pageable": {
        "pageSize": 5,
        "pageNumber": 0
    },
    "totalPages": 1,
    "totalElements": 1
    }
    ```

---

### 👨‍🎓 Adicionar Aluno a Curso

Associe um aluno a um curso específico.

* **Endpoint**: `PUT /api/cursos/{idCurso}/alunos/{idAluno}`
* **Descrição**: Adiciona um aluno a um curso existente.
* **Response Body**:
    ```json
    {
        "id": 1,
        "nome": "Homem ao máximo",
        "descricao": "Curso para homens que desejam ser mais parecidos com Jesus",
        "status": "ABERTO",
        "professor": {
        "id": 1,
        "nome": "João da Silva"
        },
        "alunos": [
        {
          "id": 1,
          "nome": "Aluno Exemplo",
          "email": "aluno@example.com"
        }
        ]
    }
    ```

---

### ▶️ Iniciar Curso

Mude o status de um curso para "Em Andamento".

* **Endpoint**: `PUT /api/cursos/{id}/iniciar`
* **Descrição**: Altera o status de um curso para `EM_ANDAMENTO`.
* **Response Body**:
    ```json
    {
      "id": 1,
      "nome": "Homem ao máximo",
      "status": "EM_ANDAMENTO"
    }
    ```

---

### 🏁 Encerrar Curso

Finalize um curso, mudando seu status para "Concluído".

* **Endpoint**: `PUT /api/cursos/{id}/encerrar`
* **Descrição**: Altera o status de um curso para `CONCLUIDO`.
* **Response Body**:
    ```json
    {
      "id": 1,
      "nome": "Homem ao máximo",
      "descricao": "Curso para homens que desejam ser mais parecidos com Jesus",
      "status": "CONCLUIDO"
    }
    ```

---

### 🗑️ Deletar Curso

Remova um curso permanentemente.

* **Endpoint**: `DELETE /api/cursos/{id}`
* **Descrição**: Deleta um curso específico do sistema.
* **Response**: `204 No Content` (Indica sucesso sem conteúdo de retorno)

---

## ⚙️ Como Executar o Projeto: Passo a Passo

Siga estas instruções simples para colocar o Portal Hombridade em funcionamento na sua máquina:

### ⬇️ Clone o repositório

Abra seu terminal e execute os comandos:

```console
git clone [https://github.com/daniellhrt/portal-hombridade.git](https://github.com/daniellhrt/portal-hombridade.git)
cd portal-hombridade
```
### 📦 Compile e execute o projeto

Utilize o Maven para compilar e iniciar a aplicação:
```console
mvn clean install
mvn spring-boot:run
```
### 📄 Acesse a documentação da API
* Após a inicialização do projeto, a documentação interativa estará disponível para você!
* A documentação da API estará disponível em: http://localhost:8080/swagger-ui.html
