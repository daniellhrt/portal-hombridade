package br.com.daniel.portalhombridade.model.curso;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCursoDTO(

        @NotBlank(message = "Nome do curso é obrigatório")
        @Schema(description = "Nome do curso", example = "Homem ao máximo")
        String nome,

        @NotBlank(message = "Descrição do curso é obrigatória")
        @Schema(description = "Descrição do curso", example = "Curso para homens que desejam ser mais parecidos com Jesus")
        String descricao,

        @NotBlank(message = "ID do professor é obrigatória")

        @Schema(description = "ID do professor responsável", example = "1")
        Long professorId

) {
}
