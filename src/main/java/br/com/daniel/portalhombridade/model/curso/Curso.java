package br.com.daniel.portalhombridade.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Representa um curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único do curso", example = "1")
    private Long id;

    @Schema(description = "Nome do curso", example = "Homem ao máximo")
    private String nome;

    @Schema(description = "Descrição do curso", example = "Curso para homens que desejam ser mais parecidos com Jesus")
    private String descricao;

    @Schema(description = "Data de início do curso", example = "17/09/2024")
    private LocalDate dataInicio;

    @Schema(description = "Hora de início do curso", example = "19:00")
    private LocalTime horaInicio;

    @Schema(description = "Local do curso", example = "AD Matriz")
    private String local;

    @ManyToOne
    @Schema(description = "Professor do curso")
    private Professor professor;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Status atual do curso", example = "ATIVO")
    private StatusCurso status;


}
