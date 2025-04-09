package com.odf.api.model.usuarios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ODF_PACIENTE")
public class OdfPaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id",nullable = false)
    private OdfUsuario usuario;

    private String convenio;

    private String numeroCarteirinha;

    @Column(columnDefinition = "TEXT")
    private String observacoes;
}
