package com.odf.api.model.usuarios;

import com.odf.api.dto.usuarios.OdfUsuarioGenericoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ODF_PACIENTE")
public class OdfPaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id",nullable = false)
    private OdfUsuario usuario;

    private String convenio;

    private String numeroCarteirinha;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    public OdfUsuarioGenericoDTO converterParaDTO(){
        OdfUsuarioGenericoDTO dto = new OdfUsuarioGenericoDTO();

        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setCelular(usuario.getCelular());
        dto.setCpf(usuario.getCpf());
        dto.setTelefone(usuario.getTelefone());
        dto.setDataNascimento(usuario.getDataNascimento());
        dto.setSexo(usuario.getSexo());

        dto.setNumeroCarteirinha(numeroCarteirinha);
        dto.setObservacoes(observacoes);
        dto.setConvenio(convenio);

        return dto;
    }
}
