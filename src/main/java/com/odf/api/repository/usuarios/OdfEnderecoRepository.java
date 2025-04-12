package com.odf.api.repository.usuarios;

import com.odf.api.model.usuarios.OdfEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdfEnderecoRepository extends JpaRepository<OdfEndereco, Long> {
}
