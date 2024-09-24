package br.com.daniel.portalhombridade.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Representa um aluno.")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único do aluno", example = "1")
    private Long id;

    @Schema(description = "Nome completo do aluno", example = "Maria da Silva")
    private String nome;

    @Schema(description = "Email do aluno", example = "maria.silva@exemplo.com")
    private String email;

    @Schema(description = "Matrícula do aluno", example = "2023001")
    private String matricula;
}

