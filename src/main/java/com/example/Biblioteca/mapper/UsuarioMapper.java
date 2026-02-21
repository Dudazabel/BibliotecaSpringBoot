package com.example.Biblioteca.mapper;

import com.example.Biblioteca.dto.usuarioDTO.UsuarioRequisicaoDTO;
import com.example.Biblioteca.dto.usuarioDTO.UsuarioRespostaDTO;
import com.example.Biblioteca.model.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioMapper {

    public Usuario DTOParaEntidade(UsuarioRequisicaoDTO requisao){
        return new Usuario(requisao.nome(), requisao.email());
    }

    public UsuarioRespostaDTO EntidadeParaDTO(Usuario usuario){
        return new UsuarioRespostaDTO(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }

    public List<UsuarioRespostaDTO> EntidadeParaDTOLista(List<Usuario> usuarios){
        return usuarios.stream()
                       .map(this::EntidadeParaDTO)
                       .toList();
    }
}
