package com.odf.api.repository.usuarios;

import com.odf.api.model.usuarios.OdfDentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdfDentistaRepository extends JpaRepository<OdfDentista, Long> {
}
