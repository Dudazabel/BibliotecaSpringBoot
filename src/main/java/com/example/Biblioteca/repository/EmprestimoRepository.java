package com.example.Biblioteca.repository;

import com.example.Biblioteca.model.Emprestimo;
import com.example.Biblioteca.util.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmprestimoRepository {

    public Emprestimo cadastrarEmprestimo(Emprestimo emprestimo) throws SQLException{
        String query = "INSERT INTO emprestimo(livro_id, usuario_id, data_emprestimo, data_devolucao) VALUES (?,?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setInt(1, emprestimo.getIdLivro());
            stmt.setInt(2, emprestimo.getIdUsuario());
            stmt.setDate(3, Date.valueOf(emprestimo.getDataEmprestimo()));
            stmt.setDate(4, Date.valueOf(emprestimo.getDataDevolucao()));
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                emprestimo.setId(rs.getInt(1));
                return emprestimo;
            }
        }
        throw new RuntimeException("Cadastro não foi realizado!");
    }

    public List<Emprestimo> listarEmprestimos() throws SQLException{
        String query = "SELECT id, livro_id, usuario_id, data_emprestimo, data_devolucao FROM emprestimo";

        List<Emprestimo> listaEmprestimo = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                int idLivro = rs.getInt("livro_id");
                int idUsuario = rs.getInt("usuario_id");
                LocalDate dataEmprestimo = rs.getDate("data_emprestimo").toLocalDate();
                LocalDate dataDevolucao = rs.getDate("data_devolucao").toLocalDate();
                Emprestimo emprestimo = new Emprestimo(id, idLivro, idUsuario, dataEmprestimo, dataDevolucao);

                listaEmprestimo.add(emprestimo);

            }
        }

        return listaEmprestimo;
    }

    public Emprestimo listarEmprestimoID(int ID) throws SQLException{
        String query = "SELECT id, livro_id, usuario_id, data_emprestimo, data_devolucao FROM emprestimo WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, ID);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                int idLivro = rs.getInt("livro_id");
                int idUsuario = rs.getInt("usuario_id");
                LocalDate dataEmprestimo = rs.getDate("data_emprestimo").toLocalDate();
                LocalDate dataDevolucao = rs.getDate("data_devolucao").toLocalDate();
                Emprestimo emprestimo = new Emprestimo(id, idLivro, idUsuario, dataEmprestimo, dataDevolucao);
                return emprestimo;
            }
        }
        throw new RuntimeException("Empréstimo não encontrado!");
    }

    public void atualizarEmprestimo(int id, Emprestimo emprestimo) throws SQLException{
        String query = "UPDATE emprestimo SET livro_id = ?, usuario_id = ?, data_emprestimo = ?, data_devolucao = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, emprestimo.getIdLivro());
            stmt.setInt(2, emprestimo.getIdUsuario());
            stmt.setDate(3, Date.valueOf(emprestimo.getDataEmprestimo()));
            stmt.setDate(4, Date.valueOf(emprestimo.getDataDevolucao()));
            stmt.setInt(5, id);
            stmt.executeUpdate();
        }
    }

    public void deletarEmprestimo(int id) throws SQLException{
        String query = "DELETE FROM emprestimo WHERE id = ? ";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void registrarDevolucao(int id, Emprestimo emprestimo) throws SQLException{
        String query = "UPDATE emprestimo SET data_devolucao = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setDate(1, Date.valueOf(emprestimo.getDataDevolucao()));
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }
}
