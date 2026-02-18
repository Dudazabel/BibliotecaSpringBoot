package com.example.Biblioteca.service;

import com.example.Biblioteca.model.Emprestimo;
import com.example.Biblioteca.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class EmprestimoService {

    private final EmprestimoRepository repository;

    public EmprestimoService (EmprestimoRepository repository){
        this.repository = repository;
    }

    public Emprestimo cadastrarEmprestimo(Emprestimo emprestimo) throws SQLException {
        return repository.cadastrarEmprestimo(emprestimo);
    }

    
}
