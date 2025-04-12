package com.odf.api.repository.usuarios;

import com.odf.api.model.usuarios.OdfPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdfPacienteRepository extends JpaRepository<OdfPaciente, Long> {

}
