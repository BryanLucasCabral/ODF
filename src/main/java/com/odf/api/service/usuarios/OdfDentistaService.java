package com.odf.api.service.usuarios;

import com.odf.api.dto.usuarios.OdfUsuarioGenericoDTO;
import com.odf.api.model.usuarios.OdfDentista;
import com.odf.api.model.usuarios.OdfUsuario;
import com.odf.api.repository.usuarios.OdfDentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OdfDentistaService {
    @Autowired
    private OdfDentistaRepository odfDentistaRepository;

    public OdfDentista salvarDentista(OdfDentista dentista){
        return odfDentistaRepository.save(dentista);
    }

    public Page<OdfUsuarioGenericoDTO> listarDentistas(Pageable paginacao){
        return odfDentistaRepository.findAll(paginacao).map(dentista -> dentista.converterParaDTO());
    }

    public OdfDentista buscarDentistaPeloId(Long id){
        Optional<OdfDentista> dentistaOpt = odfDentistaRepository.findById(id);

        if (dentistaOpt.isPresent()){
            dentistaOpt.get();
        }
        return null;
    }

    public OdfUsuarioGenericoDTO buscarUsuarioPeloIdDentista(Long id){
        Optional<OdfDentista> dentistaOpt = odfDentistaRepository.findById(id);
        if (dentistaOpt.isPresent()){
            dentistaOpt.get().getUsuario().converterParaDTO();
        }
        return null;
    }

    public OdfDentista atualizarDentista(Long id, OdfUsuarioGenericoDTO dadosDentista){
        OdfDentista dentista = buscarDentistaPeloId(id);
        OdfUsuario usuario = dentista.getUsuario();

        usuario.setNome(dadosDentista.getNome());
        usuario.setEmail(dadosDentista.getEmail());
        usuario.setCpf(dadosDentista.getCpf());
        usuario.setTelefone(dadosDentista.getTelefone());
        usuario.setCelular(dadosDentista.getCelular());
        usuario.setSexo(dadosDentista.getSexo());
        usuario.setDataNascimento(dadosDentista.getDataNascimento());

        dentista.setCro(dadosDentista.getCro());
        dentista.setStatus(dadosDentista.getStatus());
        dentista.setEspecialidade(dadosDentista.getEspecialidade());

        return odfDentistaRepository.save(dentista);
    }

    public void deletarDentista(Long id){
        odfDentistaRepository.deleteById(id);
    }
}
