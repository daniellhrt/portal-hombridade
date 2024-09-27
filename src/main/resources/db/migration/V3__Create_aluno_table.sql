CREATE TABLE aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    telefone VARCHAR(255),
    curso_id BIGINT,
    FOREIGN KEY (curso_id) REFERENCES curso(id)
);
