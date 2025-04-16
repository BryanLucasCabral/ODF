package com.odf.api.repository.usuarios;

import com.odf.api.model.usuarios.OdfUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OdfUsuarioRepository extends JpaRepository<OdfUsuario, Long> {

    Optional<OdfUsuario> findByCpf(String cpf);

    Optional<OdfUsuario> findByEmail(String email);

    Optional<OdfUsuario> findByCpfAndEmail(String cpf, String email);

    List<OdfUsuario> findByNomeContains(String nome);

    List<OdfUsuario> findByNomeLike(String nome);

}

