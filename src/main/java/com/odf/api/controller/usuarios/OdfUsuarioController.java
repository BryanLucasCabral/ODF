package com.odf.api.controller.usuarios;

import com.odf.api.dto.usuarios.OdfUsuarioDTO;
import com.odf.api.model.usuarios.OdfUsuario;
import com.odf.api.service.usuarios.OdfUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class OdfUsuarioController {

    @Autowired
    private OdfUsuarioService odfUsuarioService;

    @PostMapping
    public ResponseEntity<OdfUsuario> salvarUsuario(@RequestBody OdfUsuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(odfUsuarioService.salvarUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<OdfUsuarioDTO>> listarUsuarios(@PageableDefault(size = 10, page = 0, sort = "nome", direction = Sort.Direction.ASC)Pageable paginacao){
        return ResponseEntity.status(HttpStatus.OK).body(odfUsuarioService.listarUsuarios(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdfUsuarioDTO> buscarUsuarioPeloId(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(odfUsuarioService.buscarUsuarioPeloId(id));
    }

    @GetMapping("/busca")
    public ResponseEntity<List<OdfUsuarioDTO>> filtrarUsuariosPeloNome(@RequestParam("nome") String nome){
        return ResponseEntity.status(HttpStatus.OK).body(odfUsuarioService.filtrarUsuariosPeloNome(nome));
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<OdfUsuarioDTO>> filtrarUsuariosCujoNomeComecamCom(@RequestParam("nome") String nome){
        return ResponseEntity.status(HttpStatus.OK).body(odfUsuarioService.filtrarUsuariosCujoNomeComecamCom(nome));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<OdfUsuarioDTO> buscarUsuarioPeloCpf(@PathVariable("cpf") String cpf){
        return ResponseEntity.status(HttpStatus.OK).body(odfUsuarioService.buscarUsuarioPeloCPF(cpf));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuarioPeloId(@PathVariable("id") Long id){
        OdfUsuarioDTO usuario = odfUsuarioService.buscarUsuarioPeloId(id);

        odfUsuarioService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OdfUsuario> atualizarUsuario(@PathVariable("id") Long id, @RequestBody OdfUsuario dadosUsuario){
        return ResponseEntity.status(HttpStatus.OK).body(odfUsuarioService.atualizarUsuario(id, dadosUsuario));
    }
}
