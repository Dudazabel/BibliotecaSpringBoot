package com.example.Biblioteca.service;

import com.example.Biblioteca.model.Usuario;
import com.example.Biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }

    public Usuario cadastrarUsuario(Usuario usuario) throws SQLException{
        return repository.cadastrarUsuario(usuario);
    }

    public List<Usuario> listarUsuarios() throws SQLException{
        return repository.listarUsuarios();
    }

    public Usuario listaUsuarioID(int id) throws SQLException{
        return repository.listaUsuarioID(id);
    }

    public void atualizarUsuario(Usuario usuario, int id) throws SQLException{
        usuario.setId(id);
        repository.atualizarUsuario(usuario, id);
    }

    public void deletarUsuario(int id)throws SQLException{
        repository.deletarUsuario(id);
    }

}
