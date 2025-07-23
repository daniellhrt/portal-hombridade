package br.com.daniel.portalhombridade.model.aluno;


import br.com.daniel.portalhombridade.model.curso.Curso;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "curso")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Schema(description = "Representa um aluno.")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único do aluno")
    private Long id;

    @Schema(description = "Nome completo do aluno")
    private String nome;

    @Schema(description = "Email do aluno")
    private String email;

    @Schema(description = "Telefone do aluno")
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    @JsonIgnore // Evita recursão infinita no adicionar aluno no curso ao serializar para JSON
    private Curso curso;
}

