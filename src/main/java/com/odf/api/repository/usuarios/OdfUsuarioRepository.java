package com.odf.api.repository.usuarios;

import com.odf.api.model.usuarios.OdfUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdfUsuarioRepository extends JpaRepository<OdfUsuario, Long> {

}
