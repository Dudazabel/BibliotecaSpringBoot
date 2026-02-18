package com.example.Biblioteca.controller;

import com.example.Biblioteca.model.Emprestimo;
import com.example.Biblioteca.service.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

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
}
