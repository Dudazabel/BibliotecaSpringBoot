package com.example.Biblioteca.controller;

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
    public Emprestimo postEmprestimo(@RequestBody Emprestimo emprestimo){
        try{
            return service.cadastrarEmprestimo(emprestimo);

        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<Emprestimo> getlistaEmprestimo(){
        try{
            return service.listarEmprestimo();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Emprestimo getListaEmprestimoId(@PathVariable int id){
        try{
            return service.listarEmprestimoId(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping("/{id}")
    public void getAtualizarEmprestimo(@PathVariable int id, @RequestBody Emprestimo emprestimo){
        try{
            service.atualizarEmprestimo(id, emprestimo);
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
    public void registrarDevolucao(@PathVariable int id, @RequestBody Emprestimo emprestimo){
        try {
            service.registrarDataDevolucao(id, emprestimo);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
