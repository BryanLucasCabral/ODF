package com.odf.api.repository.procedimentos;

import com.odf.api.model.procedimentos.OdfProcedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdfProcedimentoRepository extends JpaRepository<OdfProcedimento, Long> {
}
