package br.com.daniel.portalhombridade.model.aluno;


import br.com.daniel.portalhombridade.model.curso.Curso;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}

