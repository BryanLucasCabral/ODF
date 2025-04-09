package com.odf.api.model.usuarios;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Date dataNascimento;

    @ManyToOne
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
}
