package br.com.daniel.portalhombridade;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import br.com.daniel.portalhombridade.model.aluno.Aluno;
import br.com.daniel.portalhombridade.model.aluno.AlunoRepository;
import br.com.daniel.portalhombridade.model.aluno.DadosCadastroAlunoDTO;
import br.com.daniel.portalhombridade.service.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AlunoServiceTest {

    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarAluno() {
        DadosCadastroAlunoDTO dados = new DadosCadastroAlunoDTO("Maria da Silva", "maria.silva@exemplo.com", "51 99999-9999");
        Aluno aluno = new Aluno();
        aluno.setNome(dados.nome());
        aluno.setEmail(dados.email());
        aluno.setTelefone(dados.telefone());

        when(alunoRepository.save(any(Aluno.class))).thenReturn(aluno);

        Aluno result = alunoService.criarAluno(dados);

        assertNotNull(result);
        assertEquals("Maria da Silva", result.getNome());
        assertEquals("maria.silva@exemplo.com", result.getEmail());
        assertEquals("51 99999-9999", result.getTelefone());
    }
}