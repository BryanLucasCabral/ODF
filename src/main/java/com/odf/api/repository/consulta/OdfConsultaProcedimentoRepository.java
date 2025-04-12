package com.odf.api.repository.consulta;

import com.odf.api.model.consulta.OdfConsultaProcedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdfConsultaProcedimentoRepository extends JpaRepository<OdfConsultaProcedimento, Long> {
}
