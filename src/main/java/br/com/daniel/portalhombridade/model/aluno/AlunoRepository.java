package br.com.daniel.portalhombridade.repository;

import br.com.daniel.portalhombridade.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
