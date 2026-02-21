package com.example.Biblioteca.mapper;

import com.example.Biblioteca.dto.eprestimoDTO.EmprestimoRequisicaoDTO;
import com.example.Biblioteca.dto.eprestimoDTO.EmprestimoRespostaDTO;
import com.example.Biblioteca.model.Emprestimo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmprestimoMapper {

    public Emprestimo DTOParaEntidade(EmprestimoRequisicaoDTO requisicao){
        return new Emprestimo(requisicao.idLivro(), requisicao.idUsuario(), requisicao.dataEmprestimo(), requisicao.dataDevolucao());
    }

    public EmprestimoRespostaDTO EntidadeParaDTO(Emprestimo emprestimo){
        return new EmprestimoRespostaDTO(emprestimo.getId(), emprestimo.getIdLivro(), emprestimo.getIdUsuario(), emprestimo.getDataEmprestimo(), emprestimo.getDataDevolucao());
    }

    public List<EmprestimoRespostaDTO> EntidadeParaDTOLista(List<Emprestimo> emprestimos){
        return emprestimos.stream()
                          .map(this::EntidadeParaDTO)
                          .toList();
    }

}
