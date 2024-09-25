package br.com.daniel.portalhombridade.model.curso;

import br.com.daniel.portalhombridade.model.aluno.Aluno;
import br.com.daniel.portalhombridade.model.professor.Professor;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Representa um curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToMany(mappedBy = "curso")
    private List<Aluno> alunos;

    @Enumerated(EnumType.STRING)
    private StatusCurso status;

    private boolean ativo;

    public Curso(DadosCadastroCursoDTO dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.professor = Professor.builder().id(dados.professorId()).build();
        this.status = StatusCurso.ABERTO;
        this.ativo = true;
    }

}
