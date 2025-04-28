package com.odf.api.service.usuarios;

import com.odf.api.dto.usuarios.OdfUsuarioGenericoDTO;
import com.odf.api.model.usuarios.OdfPaciente;
import com.odf.api.model.usuarios.OdfUsuario;
import com.odf.api.repository.usuarios.OdfPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdfPacienteService {
    @Autowired
    private OdfPacienteRepository odfPacienteRepository;

    public OdfPaciente salvarPaciente(OdfPaciente paciente){
        return odfPacienteRepository.save(paciente);
    }
    public Page<OdfUsuarioGenericoDTO> listarPacientes(Pageable paginacao){
        return odfPacienteRepository.findAll(paginacao).map(paciente -> paciente.converterParaDTO());
    }

    public OdfPaciente buscarPacientePeloId(Long id){
        Optional<OdfPaciente> pacienteOpt = odfPacienteRepository.findById(id);
        if (pacienteOpt.isPresent()){
            return pacienteOpt.get();
        } else {
            return null;
        }
    }

    public OdfUsuarioGenericoDTO buscarPacientePeloUsuarioId(Long id){
        Optional<OdfPaciente> pacienteOpt = odfPacienteRepository.findById(id);

        if (pacienteOpt.isPresent()){
            return pacienteOpt.get().getUsuario().converterParaDTO();
        } else {
            return null;
        }
    }

    public OdfPaciente atualizarPaciente(Long id, OdfUsuarioGenericoDTO dadosPaciente){
        OdfPaciente paciente = buscarPacientePeloId(id);
        OdfUsuario usuario = paciente.getUsuario();

        usuario.setNome(dadosPaciente.getNome());
        usuario.setEmail(dadosPaciente.getEmail());
        usuario.setCpf(dadosPaciente.getCpf());
        usuario.setTelefone(dadosPaciente.getTelefone());
        usuario.setCelular(dadosPaciente.getCelular());
        usuario.setSexo(dadosPaciente.getSexo());
        usuario.setDataNascimento(dadosPaciente.getDataNascimento());

        paciente.setConvenio(dadosPaciente.getConvenio());
        paciente.setUsuario(usuario);
        paciente.setNumeroCarteirinha(dadosPaciente.getNumeroCarteirinha());
        paciente.setObservacoes(dadosPaciente.getObservacoes());
        return odfPacienteRepository.save(paciente);
    }

    public void deletarPaciente(Long id){
        odfPacienteRepository.deleteById(id);
    }
}
