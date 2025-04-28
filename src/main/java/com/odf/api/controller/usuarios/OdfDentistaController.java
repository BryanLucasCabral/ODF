package com.odf.api.controller.usuarios;

import com.odf.api.dto.usuarios.OdfUsuarioGenericoDTO;
import com.odf.api.model.usuarios.OdfDentista;
import com.odf.api.service.usuarios.OdfDentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dentistas")
public class OdfDentistaController {
    @Autowired
    private OdfDentistaService odfDentistaService;

    @PostMapping
    public ResponseEntity<OdfDentista> salvarDentista(@RequestBody OdfDentista dentista) {
        OdfDentista dentistaSalvo = odfDentistaService.salvarDentista(dentista);
        return ResponseEntity.status(HttpStatus.CREATED).body(dentistaSalvo);
    }

    @GetMapping
    public ResponseEntity<Page<OdfUsuarioGenericoDTO>> listarDentistas(Pageable paginacao) {
        Page<OdfUsuarioGenericoDTO> dentistas = odfDentistaService.listarDentistas(paginacao);
        return ResponseEntity.ok(dentistas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdfDentista> buscarDentistaPeloId(@PathVariable Long id) {
        OdfDentista dentista = odfDentistaService.buscarDentistaPeloId(id);
        if (dentista != null) {
            return ResponseEntity.ok(dentista);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<OdfUsuarioGenericoDTO> buscarUsuarioPeloIdDentista(@PathVariable Long id) {
        OdfUsuarioGenericoDTO usuarioDTO = odfDentistaService.buscarUsuarioPeloIdDentista(id);
        if (usuarioDTO != null) {
            return ResponseEntity.ok(usuarioDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OdfDentista> atualizarDentista(@PathVariable Long id, @RequestBody OdfUsuarioGenericoDTO dadosDentista) {
        OdfDentista dentistaAtualizado = odfDentistaService.atualizarDentista(id, dadosDentista);
        return ResponseEntity.ok(dentistaAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDentista(@PathVariable Long id) {
        odfDentistaService.deletarDentista(id);
        return ResponseEntity.noContent().build();
    }
}
