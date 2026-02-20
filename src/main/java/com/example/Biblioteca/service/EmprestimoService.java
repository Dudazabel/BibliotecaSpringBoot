package com.example.Biblioteca.service;

import com.example.Biblioteca.model.Emprestimo;
import com.example.Biblioteca.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository repository;

    public EmprestimoService (EmprestimoRepository repository){
        this.repository = repository;
    }

    public Emprestimo cadastrarEmprestimo(Emprestimo emprestimo) throws SQLException {
        return repository.cadastrarEmprestimo(emprestimo);
    }

    public List<Emprestimo> listarEmprestimo() throws SQLException{
        return repository.listarEmprestimos();
    }

    public Emprestimo listarEmprestimoId(int id) throws SQLException{
        return repository.listarEmprestimoID(id);
    }

    public void atualizarEmprestimo(int id, Emprestimo emprestimo) throws SQLException{
        repository.atualizarEmprestimo(id, emprestimo);
    }

    public void deletarEmprestimo(int id) throws SQLException{
        repository.deletarEmprestimo(id);
    }

    public void registrarDataDevolucao(int id, Emprestimo emprestimo) throws SQLException{
        repository.registrarDevolucao(id, emprestimo);
    }
}
