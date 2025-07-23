package br.com.daniel.portalhombridade.model.curso;

import br.com.daniel.portalhombridade.model.aluno.DadosAlunoDTO;
import br.com.daniel.portalhombridade.model.professor.Professor;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.stream.Collectors;

public record DadosListagemCursoDTO(
        @Schema(description = "ID do curso")
        Long id,
        @Schema(description = "Nome do curso")
        String nome,
        @Schema(description = "Descrição do curso")
        String descricao,
        @Schema(description = "Status do curso")
        String status,
        @Schema(description = "Professor responsável pelo curso")
        Professor professor,

        List<DadosAlunoDTO> alunos // Adiciona a lista de alunos
) {
    public DadosListagemCursoDTO(Curso curso) {
        this(
                curso.getId(),
                curso.getNome(),
                curso.getDescricao(),
                curso.getStatus().name(),
                curso.getProfessor(),
                curso.getAlunos()
                        .stream()
                        .map(aluno -> new DadosAlunoDTO(
                                aluno.getId(),
                                aluno.getNome(),
                                aluno.getEmail()))
                        .collect(Collectors.toList()) // Mapeia os alunos para o DTO
        );
    }
}

