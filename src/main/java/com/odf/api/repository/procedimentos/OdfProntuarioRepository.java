package com.odf.api.repository.procedimentos;

import com.odf.api.model.procedimentos.OdfProntuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdfProntuarioRepository extends JpaRepository<OdfProntuario, Long> {
}
