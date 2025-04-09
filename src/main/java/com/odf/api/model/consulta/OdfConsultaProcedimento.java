package com.odf.api.model.consulta;

import com.odf.api.model.procedimentos.OdfProcedimento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ODF_CONSULTA_PROCEDIMENTO")
public class OdfConsultaProcedimento {

    @EmbeddedId
    private ConsultaProcedimentoId id;

    @ManyToOne
    @MapsId("consultaId")
    @JoinColumn(name = "consulta_id")
    private OdfConsulta consulta;

    @ManyToOne
    @MapsId("procedimentoId")
    @JoinColumn(name = "procedimento_id")
    private OdfProcedimento procedimento;

    private Integer quantidade;

    private Double precoTotal;
}
