package br.com.daniel.portalhombridade.service;

import br.com.daniel.portalhombridade.model.aluno.Aluno;
import br.com.daniel.portalhombridade.model.aluno.AlunoRepository;
import br.com.daniel.portalhombridade.model.aluno.DadosCadastroAlunoDTO;
import br.com.daniel.portalhombridade.model.aluno.DadosListagemAlunosDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public Aluno criarAluno(DadosCadastroAlunoDTO dados) {
        Aluno aluno = new Aluno();
        aluno.setNome(dados.nome());
        aluno.setEmail(dados.email());
        aluno.setTelefone(dados.telefone());
        return alunoRepository.save(aluno);
    }

    public Page<DadosListagemAlunosDTO> listarTodosAlunos(Pageable paginacao) {
        return alunoRepository.findAll(paginacao)
                .map(DadosListagemAlunosDTO::new);
    }



}