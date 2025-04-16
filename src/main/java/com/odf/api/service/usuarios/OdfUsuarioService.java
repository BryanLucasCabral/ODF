package com.odf.api.service.usuarios;

import com.odf.api.dto.usuarios.OdfUsuarioDTO;
import com.odf.api.model.usuarios.OdfUsuario;
import com.odf.api.repository.usuarios.OdfUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdfUsuarioService {
    @Autowired
    private OdfUsuarioRepository odfUsuarioRepository;

    public OdfUsuario salvarUsuario(OdfUsuario usuario) {
        return odfUsuarioRepository.save(usuario);
    }

    public Page<OdfUsuarioDTO> listarUsuarios(Pageable paginacao){
        return odfUsuarioRepository.findAll(paginacao).map(usuario -> usuario.converterParaDTO()); //colocar para dto
    }

    public OdfUsuarioDTO buscarUsuarioPeloId(Long id) {
        Optional<OdfUsuario> usuarioOpt = odfUsuarioRepository.findById(id);

        if (usuarioOpt.isPresent()){
            return usuarioOpt.get().converterParaDTO();
        }
        return null;
    }

    public  OdfUsuarioDTO buscarUsuarioPeloCPF(String cpf){
        Optional<OdfUsuario> usuarioOpt = odfUsuarioRepository.findByCpf(cpf);

        if (usuarioOpt.isPresent()){
            return usuarioOpt.get().converterParaDTO();
        }
        return  null;
    }

    public List<OdfUsuarioDTO> filtrarUsuariosPeloNome(String nome) {
        List<OdfUsuario> usuarios = odfUsuarioRepository.findByNomeContains(nome);

        return usuarios.stream().map(OdfUsuario::converterParaDTO).toList();
    }

    public List<OdfUsuarioDTO> filtrarUsuariosCujoNomeComecamCom(String nome) {
        List<OdfUsuario> usuarios = odfUsuarioRepository.findByNomeLike(nome + "%");

        return usuarios.stream().map(OdfUsuario::converterParaDTO).toList();
    }
    public void deletarUsuario(Long id){
        odfUsuarioRepository.deleteById(id);
    }
    public OdfUsuario atualizarUsuario(Long id, OdfUsuario dadosUsuario){
        Optional<OdfUsuario> usuarioOpt = odfUsuarioRepository.findById(id);

        if (usuarioOpt.isPresent()){
            OdfUsuario usuario = usuarioOpt.get();

            usuario.setNome(dadosUsuario.getNome());
            usuario.setCpf(dadosUsuario.getCpf());
            usuario.setCelular(dadosUsuario.getCelular());
            usuario.setEmail(dadosUsuario.getEmail());
            usuario.setDataNascimento(dadosUsuario.getDataNascimento());
            usuario.setUsuarioExterno(dadosUsuario.getUsuarioExterno());
            usuario.setAdministrador(dadosUsuario.getAdministrador());
            usuario.setColaborador(dadosUsuario.getColaborador());
            usuario.setSexo(dadosUsuario.getSexo());
            usuario.setEndereco(dadosUsuario.getEndereco());
            usuario.setDesenvolvedor(dadosUsuario.getDesenvolvedor());

            return odfUsuarioRepository.save(usuario);
        }
        return null;
    }
}
