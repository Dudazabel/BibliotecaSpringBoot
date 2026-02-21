package com.example.Biblioteca.service;

import com.example.Biblioteca.dto.eprestimoDTO.EmprestimoRequisicaoDTO;
import com.example.Biblioteca.dto.eprestimoDTO.EmprestimoRespostaDTO;
import com.example.Biblioteca.mapper.EmprestimoMapper;
import com.example.Biblioteca.model.Emprestimo;
import com.example.Biblioteca.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository repository;
    private final EmprestimoMapper mapper;

    public EmprestimoService (EmprestimoRepository repository, EmprestimoMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public EmprestimoRespostaDTO cadastrarEmprestimo(EmprestimoRequisicaoDTO emprestimoDTO) throws SQLException {
        Emprestimo emprestimo = mapper.DTOParaEntidade(emprestimoDTO);
        Emprestimo emprestimoSalvo = repository.cadastrarEmprestimo(emprestimo);
        return mapper.EntidadeParaDTO(emprestimoSalvo);
    }

    public List<EmprestimoRespostaDTO> listarEmprestimo() throws SQLException{
        List<Emprestimo> emprestimos = repository.listarEmprestimos();
        return  mapper.EntidadeParaDTOLista(emprestimos);
    }

    public EmprestimoRespostaDTO listarEmprestimoId(int id) throws SQLException{
        return mapper.EntidadeParaDTO(repository.listarEmprestimoID(id));
    }

    public void atualizarEmprestimo(int id, EmprestimoRequisicaoDTO emprestimoDTO) throws SQLException{
        Emprestimo emprestimo = mapper.DTOParaEntidade(emprestimoDTO);
        repository.atualizarEmprestimo(id, emprestimo);
    }

    public void deletarEmprestimo(int id) throws SQLException{
        repository.deletarEmprestimo(id);
    }

    public void registrarDataDevolucao(int id, EmprestimoRequisicaoDTO emprestimoDTO) throws SQLException{
        Emprestimo emprestimo = mapper.DTOParaEntidade(emprestimoDTO);
        repository.registrarDevolucao(id, emprestimo);
    }
}
