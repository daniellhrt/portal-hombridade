package br.com.daniel.portalhombridade.repository;

import br.com.daniel.portalhombridade.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}