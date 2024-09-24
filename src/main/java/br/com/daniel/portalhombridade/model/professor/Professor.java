package br.com.daniel.portalhombridade.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Enabled
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Representa um professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único do professor", example = "1")
    private Long id;

    @Schema(description = "Nome do professor", example = "Daniel")
    private String nome;

    @Schema(description = "Email do professor", example = "daniel.henrique@email.com ")
    private String email;

    @Schema(description = "Senha do professor", example = "123456")
    private String senha;


}
