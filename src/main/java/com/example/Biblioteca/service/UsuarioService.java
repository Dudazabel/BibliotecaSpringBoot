package com.example.Biblioteca.service;

import com.example.Biblioteca.dto.usuarioDTO.UsuarioRequisicaoDTO;
import com.example.Biblioteca.dto.usuarioDTO.UsuarioRespostaDTO;
import com.example.Biblioteca.mapper.UsuarioMapper;
import com.example.Biblioteca.model.Usuario;
import com.example.Biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public UsuarioRespostaDTO cadastrarUsuario(UsuarioRequisicaoDTO usuarioDTO) throws SQLException{
        Usuario usuario = mapper.DTOParaEntidade(usuarioDTO);
        Usuario usuarioSalvo = repository.cadastrarUsuario(usuario);
        return mapper.EntidadeParaDTO(usuarioSalvo);
    }

    public List<UsuarioRespostaDTO> listarUsuarios() throws SQLException{
        return mapper.EntidadeParaDTOLista(repository.listarUsuarios());
    }

    public UsuarioRespostaDTO listaUsuarioID(int id) throws SQLException{
        return mapper.EntidadeParaDTO(repository.listaUsuarioID(id));
    }

    public void atualizarUsuario(UsuarioRequisicaoDTO usuarioDTO, int id) throws SQLException{
        Usuario usuario = mapper.DTOParaEntidade(usuarioDTO);
        repository.atualizarUsuario(usuario, id);
    }

    public void deletarUsuario(int id)throws SQLException{
        repository.deletarUsuario(id);
    }

}
