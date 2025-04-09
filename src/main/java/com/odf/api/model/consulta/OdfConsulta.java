package com.odf.api.model.consulta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.odf.api.enums.StatusConsulta;
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
@Entity(name = "ODF_CONSULTA")
public class OdfConsulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private OdfPaciente paciente;

    @ManyToOne
    @JoinColumn(name = "dentista_id", nullable = false)
    private OdfDentista dentista;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataHora;

    private String motivo;

    private String observacoes;

    private StatusConsulta status;
}
