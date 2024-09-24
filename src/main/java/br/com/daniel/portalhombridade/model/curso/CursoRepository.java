package br.com.daniel.portalhombridade.repository;

import br.com.daniel.portalhombridade.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
