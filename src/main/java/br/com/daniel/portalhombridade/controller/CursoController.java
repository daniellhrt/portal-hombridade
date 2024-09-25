package br.com.daniel.portalhombridade.controller;


import br.com.daniel.portalhombridade.model.curso.*;
import br.com.daniel.portalhombridade.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
@Tag(name = "Curso", description = "Endpoints relacionadas a cursos")
public class CursoController {

    private final CursoService cursoService;

    //**************************** REFATORADO ********************************
    @PostMapping
    @Transactional
    @Operation(summary = "Criar um novo curso")
    public ResponseEntity criarCurso(@RequestBody DadosCadastroCursoDTO dados,
                                     UriComponentsBuilder uriBuider) {
        Curso curso = cursoService.criarCurso(dados);
        var uri = uriBuider.path("/cursos/{id}")
                .buildAndExpand(curso.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new DadosAtualizadoDetalhadoCursoDTO(curso));
    }

    //**************************** REFATORADO ********************************
    @GetMapping
    @Operation(summary = "Listar todos os cursos")
    public ResponseEntity<Page<DadosListagemCursoDTO>> listar(@PageableDefault
                                                                      (size = 5, sort = {"nome"}) Pageable paginacao) {
        var page = cursoService.listarTodosCursos(paginacao);
        return ResponseEntity.ok(page);
    }

    //**************************** REFATORADO ********************************
    @PutMapping("/{id}/iniciar")
    @Transactional
    @Operation(summary = "Inicia um curso")
    public ResponseEntity iniciarCurso(@PathVariable Long id) {
        Curso curso = cursoService.iniciarCurso(id);
        return ResponseEntity.ok(new DadosInicioCurso(curso));
    }

    @PutMapping("/{id}/encerrar")
    @Operation(summary = "Encerra um curso")
    public ResponseEntity encerrarCurso(@PathVariable Long id) {
        Curso curso = cursoService.encerrarCurso(id);
        return ResponseEntity.ok(new DadosEncerramentoCurso(curso));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um curso")
    public ResponseEntity<Void> deletarCurso(@PathVariable Long id) {
        cursoService.deletarCurso(id);
        return ResponseEntity.noContent().build();
    }


}
