package com.example.Biblioteca.service;

import com.example.Biblioteca.model.Livro;
import com.example.Biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository){
        this.repository = repository;
    }

    public Livro cadastrarLivro(Livro livro) throws SQLException{
        return repository.cadastrarlivro(livro);
    }

    public List<Livro> listaLivros() throws SQLException{
        return repository.listarLivros();
    }

    public Livro listaLivroID(int id) throws SQLException{
        return repository.listarLivroID(id);
    }

    public void atualizarLivro(Livro livro, int id) throws SQLException{
        livro.setId(id);
        repository.atualizarLivro(livro, id);
    }

    public void deletarLivro(int id) throws SQLException{
        repository.deletarLivro(id);
    }

}
