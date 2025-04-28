package com.odf.api.controller.usuarios;

import com.odf.api.dto.usuarios.OdfEnderecoDTO;
import com.odf.api.dto.usuarios.OdfUsuarioGenericoDTO;
import com.odf.api.model.usuarios.OdfEndereco;
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
import java.util.Objects;

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
    public ResponseEntity<Page<OdfUsuarioGenericoDTO>> listarUsuarios(@PageableDefault(size = 10, page = 0, sort = "nome", direction = Sort.Direction.ASC)Pageable paginacao){
        return ResponseEntity.status(HttpStatus.OK).body(odfUsuarioService.listarUsuarios(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdfUsuarioGenericoDTO> buscarUsuarioPeloId(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(odfUsuarioService.buscarUsuarioPeloId(id));
    }

    @GetMapping("/busca")
    public ResponseEntity<List<OdfUsuarioGenericoDTO>> filtrarUsuariosPeloNome(@RequestParam("nome") String nome){
        return ResponseEntity.status(HttpStatus.OK).body(odfUsuarioService.filtrarUsuariosPeloNome(nome));
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<OdfUsuarioGenericoDTO>> filtrarUsuariosCujoNomeComecamCom(@RequestParam("nome") String nome){
        return ResponseEntity.status(HttpStatus.OK).body(odfUsuarioService.filtrarUsuariosCujoNomeComecamCom(nome));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<OdfUsuarioGenericoDTO> buscarUsuarioPeloCpf(@PathVariable("cpf") String cpf){
        return ResponseEntity.status(HttpStatus.OK).body(odfUsuarioService.buscarUsuarioPeloCPF(cpf));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuarioPeloId(@PathVariable("id") Long id){
        OdfUsuarioGenericoDTO usuario = odfUsuarioService.buscarUsuarioPeloId(id);
        if (Objects.isNull(usuario)){
            ResponseEntity.notFound().build();
        }

        odfUsuarioService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}/endereco")
    public ResponseEntity<OdfUsuario> atualizarEnderecoUsuario(@PathVariable("id") Long id, @RequestBody OdfEnderecoDTO enderecoDTO){

        OdfEndereco novoEndereco = new OdfEndereco();

        novoEndereco.setLogradouro(enderecoDTO.getLogradouro());
        novoEndereco.setNumero(enderecoDTO.getNumero());
        novoEndereco.setComplemento(enderecoDTO.getComplemento());
        novoEndereco.setBairro(enderecoDTO.getBairro());
        novoEndereco.setCidade(enderecoDTO.getCidade());
        novoEndereco.setEstado(enderecoDTO.getEstado());
        novoEndereco.setCep(enderecoDTO.getCep());

        OdfUsuario usuarioAtualizado = odfUsuarioService.atualizarEndereco(id, novoEndereco);
        return ResponseEntity.ok(usuarioAtualizado);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OdfUsuario> atualizarUsuario(@PathVariable("id") Long id, @RequestBody OdfUsuario dadosUsuario){
        return ResponseEntity.status(HttpStatus.OK).body(odfUsuarioService.atualizarUsuario(id, dadosUsuario));
    }
}
