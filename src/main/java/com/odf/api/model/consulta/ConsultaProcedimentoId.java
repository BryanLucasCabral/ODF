package com.odf.api.model.consulta;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ConsultaProcedimentoId implements Serializable {

    @Column(name = "consulta_id")
    private Long consultaId;

    @Column(name = "procedimento_id")
    private Long procedimentoId;
}
