package com.odf.api.repository.consulta;

import com.odf.api.model.consulta.OdfConsulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdfConsultaRepository  extends JpaRepository<OdfConsulta, Long> {
}
