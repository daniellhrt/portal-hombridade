package br.com.daniel.portalhombridade.model.curso;

public record DadosEncerramentoCurso(
        Long id,
        String nome,
        String descricao,
        String status
) {
    public DadosEncerramentoCurso(Curso curso) {
        this(
                curso.getId(),
                curso.getNome(),
                curso.getDescricao(),
                curso.getStatus().name()
        );
    }
}
