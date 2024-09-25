package br.com.daniel.portalhombridade.model.curso;

public record DadosEncerramentoCursoDTO(
        Long id,
        String nome,
        String descricao,
        String status
) {
    public DadosEncerramentoCursoDTO(Curso curso) {
        this(
                curso.getId(),
                curso.getNome(),
                curso.getDescricao(),
                curso.getStatus().name()
        );
    }
}
