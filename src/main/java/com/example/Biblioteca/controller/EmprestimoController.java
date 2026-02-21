package com.example.Biblioteca.controller;

import com.example.Biblioteca.dto.eprestimoDTO.EmprestimoRequisicaoDTO;
import com.example.Biblioteca.dto.eprestimoDTO.EmprestimoRespostaDTO;
import com.example.Biblioteca.model.Emprestimo;
import com.example.Biblioteca.service.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/bibliotecaEmprestimo")
public class EmprestimoController {

    private final EmprestimoService service;

    public EmprestimoController(EmprestimoService service){
        this.service = service;
    }

    @PostMapping
    public EmprestimoRespostaDTO postEmprestimo(@RequestBody EmprestimoRequisicaoDTO emprestimoDTO){
        try{
            return service.cadastrarEmprestimo(emprestimoDTO);

        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<EmprestimoRespostaDTO> getlistaEmprestimo(){
        try{
            return service.listarEmprestimo();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public EmprestimoRespostaDTO getListaEmprestimoId(@PathVariable int id){
        try{
            return service.listarEmprestimoId(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public void getAtualizarEmprestimo(@PathVariable int id, @RequestBody EmprestimoRequisicaoDTO emprestimoDTO){
        try{
            service.atualizarEmprestimo(id, emprestimoDTO);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEmprestimo(@PathVariable int id){
        try{
            service.deletarEmprestimo(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}/devolucao")
    public void registrarDevolucao(@PathVariable int id, @RequestBody EmprestimoRequisicaoDTO emprestimoDTO){
        try {
            service.registrarDataDevolucao(id, emprestimoDTO);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
