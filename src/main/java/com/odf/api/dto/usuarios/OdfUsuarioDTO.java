package com.odf.api.dto.usuarios;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OdfUsuarioDTO {
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String celular;
    private Date dataNascimento;
}
