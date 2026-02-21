package com.example.Biblioteca.service;

import com.example.Biblioteca.dto.livroDTO.LivroRequisicaoDTO;
import com.example.Biblioteca.dto.livroDTO.LivroRespostaDTO;
import com.example.Biblioteca.mapper.LivroMapper;
import com.example.Biblioteca.model.Emprestimo;
import com.example.Biblioteca.model.Livro;
import com.example.Biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;

    private final LivroMapper mapper;

    public LivroService(LivroRepository repository, LivroMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public LivroRespostaDTO cadastrarLivro(LivroRequisicaoDTO livroDTO) throws SQLException{
        Livro livro = mapper.DTOParaEntidade(livroDTO);
        Livro livroSalvo = repository.cadastrarlivro(livro);
        return mapper.EntidadeParaDTO(livroSalvo);
    }

    public List<LivroRespostaDTO> listaLivros() throws SQLException{
        List<Livro> livros = repository.listarLivros();
        return mapper.EntidadeParaDTOList(livros);
    }

    public LivroRespostaDTO listaLivroID(int id) throws SQLException{
        Livro livro = repository.listarLivroID(id);
        return mapper.EntidadeParaDTO(livro);
    }

    public void atualizarLivro(LivroRequisicaoDTO livroDTO, int id) throws SQLException{
        Livro livro = mapper.DTOParaEntidade(livroDTO);
        repository.atualizarLivro(livro, id);
    }

    public void deletarLivro(int id) throws SQLException{
        repository.deletarLivro(id);
    }

}
