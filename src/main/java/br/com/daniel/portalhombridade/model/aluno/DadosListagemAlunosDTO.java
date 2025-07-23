package br.com.daniel.portalhombridade.model.aluno;

import io.swagger.v3.oas.annotations.media.Schema;

public record DadosListagemAlunosDTO(
        @Schema(description = "ID do aluno")
        Long id,
        @Schema(description = "Nome do aluno")
        String nome,
        @Schema(description = "Email do aluno")
        String email,
        @Schema(description = "Telefone do aluno")
        String telefone
) {
    public DadosListagemAlunosDTO(Aluno aluno) {
        this(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getTelefone()
        );
    }
}
