package com.odf.api.model.usuarios;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.odf.api.dto.usuarios.OdfUsuarioGenericoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_USUARIO")
public class OdfUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    private String sexo;

    @Column(nullable = false)
    private String email;

    private String telefone;

    @Column(nullable = false)
    private String celular;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private OdfEndereco endereco;

    @Column(nullable = false)
    private Boolean administrador;

    @Column(nullable = false)
    private Boolean colaborador;

    @Column(nullable = false)
    private Boolean desenvolvedor;

    @Column(nullable = false)
    private Boolean usuarioExterno;

    public OdfUsuarioGenericoDTO converterParaDTO(){
        OdfUsuarioGenericoDTO dto = new OdfUsuarioGenericoDTO();

        dto.setNome(nome);
        dto.setEmail(email);
        dto.setCpf(cpf);
        dto.setTelefone(telefone);
        dto.setCelular(celular);
        dto.setDataNascimento(dataNascimento);
        dto.setSexo(sexo);

        return dto;
    }
}
