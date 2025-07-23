package br.com.daniel.portalhombridade.model.curso;

import br.com.daniel.portalhombridade.model.aluno.Aluno;
import br.com.daniel.portalhombridade.model.professor.Professor;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record DadosAtualizadoDetalhadoCursoDTO(
        Long id,
        @NotBlank(message = "Nome do curso é obrigatório")
        @Schema(description = "Nome do curso (DTO DETALHADO)", example = "Homem ao máximo")
        String nome,
        @NotBlank(message = "Descrição do curso é obrigatório")
        @Schema(description = "Descrição do curso (DTO DETALHADO)", example = "Curso para homens que desejam ser mais parecidos com Jesus")
        String descricao,
        @NotBlank(message = "Nome do professor é obrigatório")
        @Schema(description = "Nome professor responsavel (DTO DETALHADO)", example = "Daniel Teixeira")
        Professor professor,
        List<Aluno> alunos
) {
    public DadosAtualizadoDetalhadoCursoDTO(Curso curso) {
        this(
                curso.getId(),
                curso.getNome(),
                curso.getDescricao(),
                curso.getProfessor(),
                curso.getAlunos()
        );
    }
}
