package com.example.Biblioteca.repository;

import com.example.Biblioteca.model.Emprestimo;
import com.example.Biblioteca.util.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;

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
}
