CREATE TABLE curso (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    descricao TEXT,
    professor_id BIGINT,
    status VARCHAR(255) CHECK (status IN ('ABERTO', 'FECHADO', 'EM_ANDAMENTO')),
    ativo BOOLEAN,
    FOREIGN KEY (professor_id) REFERENCES professor(id)
);
