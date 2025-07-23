package br.com.daniel.portalhombridade.service;

import br.com.daniel.portalhombridade.model.aluno.Aluno;
import br.com.daniel.portalhombridade.model.aluno.AlunoRepository;
import br.com.daniel.portalhombridade.model.curso.*;
import br.com.daniel.portalhombridade.model.professor.Professor;
import br.com.daniel.portalhombridade.model.professor.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;
    private final ProfessorRepository professorRepository;
    private final AlunoRepository alunoRepository;

    //************************************************************
    //************************************************************

    public Curso criarCurso(DadosCadastroCursoDTO dados) {
        Professor professor = professorRepository
                .findById(dados.professorId())
                .orElseThrow();

        Curso curso = new Curso(dados);
        curso.setProfessor(professor);
        curso.setStatus(StatusCurso.ABERTO);
        return cursoRepository.save(curso);
    }

    //************************************************************
    //************************************************************

    public Curso cadastrarAluno(Long idCurso, Long idAluno) {
        Curso curso = cursoRepository
                .findById(idCurso)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));

        Aluno aluno = alunoRepository
                .findById(idAluno)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        if (curso.getAlunos() != null && curso.getAlunos().stream().allMatch(
                a -> a.getId().equals(idAluno))){
            throw new IllegalArgumentException("Aluno já está matriculado neste curso");
        }

        curso.adicionarAluno(aluno);
        return cursoRepository.save(curso);
    }

    //************************************************************
    //************************************************************

    public Page<DadosListagemCursoDTO> listarTodosCursos(Pageable paginacao) {
        return cursoRepository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemCursoDTO::new);
    }

    //************************************************************
    //************************************************************

    public Curso iniciarCurso(Long id) {
        Curso curso = cursoRepository
                .findById(id)
                .orElseThrow();

        curso.setStatus(StatusCurso.EM_ANDAMENTO);
        return cursoRepository.save(curso);
    }

    //************************************************************
    //************************************************************

    public Curso encerrarCurso(Long id) {
        Curso curso = cursoRepository
                .findById(id)
                .orElseThrow();

        curso.setStatus(StatusCurso.CONCLUIDO);
        return cursoRepository.save(curso);
    }

    public void deletarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}
