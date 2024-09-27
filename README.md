# Portal Hombridade

Este projeto é uma aplicação Spring Boot que gerencia cursos, professores e alunos. Abaixo está uma explicação detalhada
dos principais componentes e funcionalidades do projeto.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework para criar aplicações Java.
- **Spring Data JPA**: Abstração para acesso a dados com JPA.
- **Maven**: Ferramenta de gerenciamento de dependências e build.
- **Swagger**: Ferramenta para documentação de APIs REST.
- **Jakarta Persistence (JPA)**: API para mapeamento objeto-relacional.

## Estrutura do Projeto

### Modelos (Models)

- `Curso`: Representa um curso.
- `Professor`: Representa um professor.
- `Aluno`: Representa um aluno.
- `StatusCurso`: Enum que define os diferentes status que um curso pode ter (`ABERTO`, `EM_ANDAMENTO`, `CONCLUIDO`).

### DTOs (Data Transfer Objects)

- `DadosCadastroCursoDTO`: Utilizado para transferir dados ao criar um novo curso.
- `DadosAtualizadoDetalhadoCursoDTO`: Utilizado para transferir dados detalhados de um curso atualizado.
- `DadosEncerramentoCursoDTO`: Utilizado para transferir dados ao encerrar um curso.
- `DadosInicioCursoDTO`: Utilizado para transferir dados ao iniciar um curso.
- `DadosListagemCursoDTO`: Utilizado para transferir dados ao listar cursos.

### Repositórios (Repositories)

- `CursoRepository`: Interface que estende `JpaRepository` para operações CRUD e consultas específicas para a
  entidade `Curso`.

### Serviços (Services)

- `CursoService`: Contém a lógica de negócios para operações relacionadas a cursos.

### Controladores (Controllers)

- `CursoController`: Define os endpoints da API REST para operações relacionadas a cursos.

## Endpoints da API

### Criar Curso

- **Endpoint**: `POST /api/cursos`
- **Descrição**: Cria um novo curso com os dados fornecidos.
- **Request Body**:
  ```json
  {
    "nome": "Homem ao máximo",
    "descricao": "Curso para homens que desejam ser mais parecidos com Jesus",
    "professorId": 1
  }
    ```
    - **Reponse Body**:
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

### Listar Cursos

- **Endpoint**: `GET /api/cursos`
- **Descrição**: Lista todos os cursos ativos com paginação.
- **Response Body**:
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

### Adicionar Aluno a Curso

- **Endpoint**: `PUT /api/cursos/{idCurso}/alunos/{idAluno}`
- **Descrição**: Adiciona um aluno a um curso específico.
- **Response Body**:
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

### Iniciar Curso

- **Endpoint**: `PUT /api/cursos/{id}/iniciar`
- **Descrição**: Altera o status de um curso para EM_ANDAMENTO.
- **Response Body**:
   ```json
    {
      "id": 1,
      "nome": "Homem ao máximo",
      "status": "EM_ANDAMENTO"
     } 
  ```
  ### Encerrar Curso
- **Endpoint**: `PUT /api/cursos/{id}/encerrar`
- **Descrição**: Altera o status de um curso para CONCLUIDO.
- **Response Body**:
   ```json
  {
    "id": 1,
    "nome": "Homem ao máximo",
    "descricao": "Curso para homens que desejam ser mais parecidos com Jesus",
    "status": "CONCLUIDO"
  }
  ```
  ### Deletar Curso
- **Endpoint**: `DELETE /api/cursos/{id}`
- **Descrição**: Deleta um curso específico.
- **Response**: `204 No Content`

## Como Executar o Projeto

- **Clone o repositório**:

```console
git clone https://github.com/daniellhrt/portal-hombridade.git
cd portal-hombridade
```

- **Compile e execute o projeto**:

```console
mvn clean install
mvn spring-boot:run
```

### Acesse a documentação da API:

- **A documentação da API estará disponível em** http://localhost:8080/swagger-ui.html.
