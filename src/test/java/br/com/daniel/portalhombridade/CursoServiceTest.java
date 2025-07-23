package br.com.daniel.portalhombridade;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import br.com.daniel.portalhombridade.model.curso.Curso;
import br.com.daniel.portalhombridade.model.curso.CursoRepository;
import br.com.daniel.portalhombridade.model.curso.DadosCadastroCursoDTO;
import br.com.daniel.portalhombridade.model.professor.Professor;
import br.com.daniel.portalhombridade.model.professor.ProfessorRepository;
import br.com.daniel.portalhombridade.service.CursoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @Mock
    private ProfessorRepository professorRepository;

    @InjectMocks
    private CursoService cursoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarCurso() {
        // Cria um objeto Professor com ID 1
        Professor professor = new Professor();
        professor.setId(1L);

        // Configura o mock para retornar um Optional contendo o Professor quando findById(1L) for chamado
        when(professorRepository.findById(1L)).thenReturn(Optional.of(professor));

        // Configura o mock para retornar um novo Curso quando save for chamado
        when(cursoRepository.save(any(Curso.class))).thenReturn(new Curso());

        // Cria um DTO com os dados do curso
        DadosCadastroCursoDTO dados = new DadosCadastroCursoDTO("Curso Teste", "Descrição Teste", 1L);

        // Chama o método criarCurso e armazena o resultado
        Curso result = cursoService.criarCurso(dados);

        // Verifica se o resultado não é nulo e se o nome do curso está correto
        assertNotNull(result);
        assertEquals("Curso Teste", result.getNome());
    }
}