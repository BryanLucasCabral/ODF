package com.odf.api.controller.usuarios;

import com.odf.api.dto.usuarios.OdfUsuarioGenericoDTO;
import com.odf.api.model.usuarios.OdfPaciente;
import com.odf.api.service.usuarios.OdfPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/pacientes")
public class OdfPacienteController {

    @Autowired
    private OdfPacienteService odfPacienteService;

    @PostMapping
    public ResponseEntity<OdfPaciente> salvarPaciente(@RequestBody OdfPaciente paciente){
        return ResponseEntity.status(HttpStatus.CREATED).body(odfPacienteService.salvarPaciente(paciente));
    }
    @GetMapping
    public ResponseEntity<Page<OdfUsuarioGenericoDTO>> listarPacientes(@PageableDefault(size = 10, page = 0, sort = "numeroCarteirinha", direction = Sort.Direction.ASC)Pageable paginacao){
        return ResponseEntity.ok(odfPacienteService.listarPacientes(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdfPaciente> buscarPacientePeloId(@PathVariable("id") Long id){
        return ResponseEntity.ok(odfPacienteService.buscarPacientePeloId(id));
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<OdfUsuarioGenericoDTO> buscarPacientePeloUsuarioId(@PathVariable("id") Long id){
        return ResponseEntity.ok(odfPacienteService.buscarPacientePeloUsuarioId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OdfPaciente> atualizarPaciente(@PathVariable("id") Long id, @RequestBody OdfUsuarioGenericoDTO dadosPaciente){
        return ResponseEntity.ok(odfPacienteService.atualizarPaciente(id, dadosPaciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable("id") Long id){
        OdfPaciente paciente = odfPacienteService.buscarPacientePeloId(id);
        if (Objects.isNull(paciente)){
            return ResponseEntity.notFound().build();
        }

        odfPacienteService.deletarPaciente(id);
        return ResponseEntity.noContent().build();
    }
}
