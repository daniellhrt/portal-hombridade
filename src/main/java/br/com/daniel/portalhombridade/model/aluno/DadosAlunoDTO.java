package br.com.daniel.portalhombridade.model.aluno;

import io.swagger.v3.oas.annotations.media.Schema;

public record DadosAlunoDTO(
        @Schema(description = "ID do aluno", example = "1")
        Long id,

        @Schema(description = "Nome do aluno", example = "Daniel")
        String nome,

        @Schema(description = "Email do aluno", example = "email.aluno@email.com.br")
        String email) {
}
// DadosAlunoDTO é um record que representa as informações básicas de um aluno
// utilizado para transferir dados entre camadas da aplicação, especialmente em APIs.