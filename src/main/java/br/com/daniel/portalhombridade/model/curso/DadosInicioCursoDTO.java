package br.com.daniel.portalhombridade.model.curso;

public record DadosInicioCursoDTO(
        Long id,
        String nome,
        String status

) {

    public DadosInicioCursoDTO(Curso curso) {
        this(
                curso.getId(),
                curso.getNome(),
                curso.getStatus().name()
        );
    }
}
