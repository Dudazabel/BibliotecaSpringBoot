package com.example.Biblioteca.mapper;

import com.example.Biblioteca.dto.livroDTO.LivroRequisicaoDTO;
import com.example.Biblioteca.dto.livroDTO.LivroRespostaDTO;
import com.example.Biblioteca.model.Livro;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LivroMapper {

    public Livro DTOParaEntidade(LivroRequisicaoDTO requisicao){
        return new Livro(requisicao.titulo(), requisicao.autor(), requisicao.anoPublicacao());
    }

    public LivroRespostaDTO EntidadeParaDTO(Livro livro){
        return new LivroRespostaDTO(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao());
    }

    public List<LivroRespostaDTO> EntidadeParaDTOList(List<Livro> livros){
        return livros.stream()
                     .map(this::EntidadeParaDTO)
                     .toList();
    }
}
