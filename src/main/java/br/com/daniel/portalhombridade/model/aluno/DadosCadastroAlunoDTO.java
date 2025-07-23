package br.com.daniel.portalhombridade.model.aluno;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAlunoDTO(

        @NotBlank(message = "Nome do aluno é obrigatório")
        @Schema(description = "Nome do aluno", example = "Maria da Silva")
        String nome,

        @NotBlank(message = "Email do aluno é obrigatório")
        @Email(message = "Email inválido")
        @Schema(description = "Email do aluno", example = "maria.silva@exemplo.com")
        String email,

        @NotBlank(message = "Telefone do aluno é obrigatório")
        @Pattern(regexp = "\\d{2} \\d{5}-\\d{4}", message = "Telefone deve estar no formato XX XXXXX-XXXX")
        @Schema(description = "Telefone do aluno", example = "51 99999-9999")
        String telefone
) {
}