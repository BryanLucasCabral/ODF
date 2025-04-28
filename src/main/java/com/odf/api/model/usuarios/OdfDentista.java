package com.odf.api.model.usuarios;

import com.odf.api.dto.usuarios.OdfUsuarioGenericoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ODF_DENTISTA")
public class OdfDentista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private OdfUsuario usuario;

    @Column(nullable = false)
    private  String cro;

    private String especialidade;

    @Column(nullable = false)
    private Boolean status;

    public OdfUsuarioGenericoDTO converterParaDTO(){
        OdfUsuarioGenericoDTO dto = new OdfUsuarioGenericoDTO();

        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setCelular(usuario.getCelular());
        dto.setCpf(usuario.getCpf());
        dto.setTelefone(usuario.getTelefone());
        dto.setDataNascimento(usuario.getDataNascimento());
        dto.setSexo(usuario.getSexo());

        dto.setCro(cro);
        dto.setEspecialidade(especialidade);
        dto.setStatus(status);

        return dto;
    }
}
