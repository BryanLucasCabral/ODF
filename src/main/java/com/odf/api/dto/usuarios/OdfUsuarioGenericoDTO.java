package com.odf.api.dto.usuarios;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OdfUsuarioGenericoDTO {
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String celular;
    private LocalDate dataNascimento;
    private String sexo;
    private String cro;
    private String especialidade;
    private Boolean status;
    private String convenio;
    private String numeroCarteirinha;
    private String observacoes;
}
