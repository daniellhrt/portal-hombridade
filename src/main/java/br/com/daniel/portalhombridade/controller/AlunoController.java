package br.com.daniel.portalhombridade.controller;

import br.com.daniel.portalhombridade.model.aluno.Aluno;
import br.com.daniel.portalhombridade.model.aluno.DadosAlunoDTO;
import br.com.daniel.portalhombridade.model.aluno.DadosCadastroAlunoDTO;
import br.com.daniel.portalhombridade.model.aluno.DadosListagemAlunosDTO;
import br.com.daniel.portalhombridade.model.curso.Curso;
import br.com.daniel.portalhombridade.service.AlunoService;
import br.com.daniel.portalhombridade.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/alunos")
@RequiredArgsConstructor
@Tag(name = "Aluno", description = "Endpoints relacionadas a alunos")
public class AlunoController {

    private final AlunoService alunoService;
    private final CursoService cursoService;

    @PostMapping
    @Transactional
    @Operation(summary = "Cria um aluno e o inscreve em um curso")
    public ResponseEntity<DadosAlunoDTO> criarAlunoInscreverNoCurso(
            @Valid @RequestBody DadosCadastroAlunoDTO dados,
            @RequestParam Long cursoId,
            UriComponentsBuilder uriBuilder) {
        Aluno aluno = alunoService.criarAluno(dados);
        cursoService.cadastrarAluno(cursoId, aluno.getId());
        var uri = uriBuilder.path("/api/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosAlunoDTO(aluno.getId(), aluno.getNome(), aluno.getEmail()));
    }

    @GetMapping
    @Operation(summary = "Listar todos os alunos")
    public ResponseEntity<Page<DadosListagemAlunosDTO>> listar(
            @PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao) {

        var page = alunoService.listarTodosAlunos(paginacao);
        return ResponseEntity.ok(page);
    }

}
