package com.odf.api.model.usuarios;

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
}
