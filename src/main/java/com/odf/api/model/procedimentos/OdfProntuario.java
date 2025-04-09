package com.odf.api.model.procedimentos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.odf.api.model.usuarios.OdfDentista;
import com.odf.api.model.usuarios.OdfPaciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ODF_PRONTUARIO")
public class OdfProntuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private OdfPaciente paciente;

    @ManyToOne
    @JoinColumn(name = "dentista_id")
    private OdfDentista dentista;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataRegistro;

    @Column(columnDefinition = "TEXT")
    private String descricao;
}
