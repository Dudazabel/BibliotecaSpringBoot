package com.example.Biblioteca.repository;

import com.example.Biblioteca.model.Livro;
import com.example.Biblioteca.util.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LivroRepository {

    public Livro cadastrarlivro(Livro livro) throws SQLException {
        String query = "INSERT INTO livro(titulo, autor, ano_publicacao) VALUES (?,?,?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1,livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAnoPublicacao());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                livro.setId(rs.getInt(1));
                return livro;
            }
        }

        throw new RuntimeException("Erro no cadastro!");
    }

    public List<Livro> listarLivros()throws SQLException{
        String query = "SELECT id, titulo, autor, ano_publicacao FROM livro";

        List<Livro> listaLivros = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int anoPublicacao = rs.getInt("ano_publicacao");

                Livro livro = new Livro(id, titulo, autor, anoPublicacao);
                listaLivros.add(livro);
            }
        }
        return listaLivros;
    }

    public Livro listarLivroID(int ID) throws SQLException{
        String query = "SELECT id, titulo, autor, ano_publicacao FROM livro WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, ID);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int anoPublicacao = rs.getInt("ano_publicacao");

                Livro livro = new Livro(id, titulo, autor, anoPublicacao);
                return livro;
            }
        }
        throw new RuntimeException("Livro não encontrado!");
    }

    public void atualizarLivro(Livro livro, int id) throws SQLException{
        String query = "UPDATE livro SET titulo = ?, autor = ?, ano_publicacao = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAnoPublicacao());
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    public void deletarLivro(int id) throws SQLException{
        String query = "DELETE FROM livro WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
