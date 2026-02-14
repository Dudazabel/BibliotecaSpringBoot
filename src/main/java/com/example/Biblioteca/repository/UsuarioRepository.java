package com.example.Biblioteca.repository;

import com.example.Biblioteca.model.Usuario;
import com.example.Biblioteca.util.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    public Usuario cadastrarUsuario(Usuario usuario) throws SQLException{
        String query = "INSERT INTO usuario(nome, email) VALUES (?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                usuario.setId(rs.getInt(1));
                return usuario;
            }

            throw new RuntimeException("Cadastro não concluído!");
        }
    }

    public List<Usuario> listarUsuarios() throws SQLException{
        String query = "SELECT id, nome, email FROM usuario";

        List<Usuario> listaUsuarios = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                Usuario usuario = new Usuario(id, nome, email);
                listaUsuarios.add(usuario);
            }
        }
        return listaUsuarios;
    }

    public Usuario listaUsuarioID(int id)throws SQLException{
        String query = "SELECT id, nome, email FROM usuario WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int ID = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                Usuario usuario = new Usuario(id, nome, email);
                return usuario;
            }
        }
        throw new RuntimeException("Usuário não encontrado!");
    }

    public void atualizarUsuario(Usuario usuario, int id) throws SQLException{
        String query = "UPDATE usuario SET nome = ?, email = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }

    public void deletarUsuario(int id) throws SQLException{
        String query = "DELETE FROM usuario WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
