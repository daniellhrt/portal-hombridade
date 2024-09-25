package br.com.daniel.portalhombridade.model.curso;

import br.com.daniel.portalhombridade.model.professor.Professor;

public record DadosListagemCursoDTO(
        Long id,
        String nome,
        String descricao,
        String status,
        Professor professor
) {
    public DadosListagemCursoDTO(Curso curso) {
        this(
                curso.getId(),
                curso.getNome(),
                curso.getDescricao(),
                curso.getStatus().name(),
                curso.getProfessor()
        );
    }
}