package br.com.daniel.portalhombridade.model.curso;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Define os diferentes Status que um curso pode ter")
public enum StatusCurso {
    ABERTO, EM_ANDAMENTO, CONCLUIDO
}
