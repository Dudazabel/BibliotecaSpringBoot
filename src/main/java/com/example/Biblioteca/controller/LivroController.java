package com.example.Biblioteca.controller;

import com.example.Biblioteca.model.Livro;
import com.example.Biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/bibliotecaLivro")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @PostMapping
    public Livro postLivro (@RequestBody Livro livro) {
        try{
            return service.cadastrarLivro(livro);

        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<Livro> getListaLivro(){
        try{
            return service.listaLivros();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Livro getListaLivroID(@PathVariable int id){
        try{
            return service.listaLivroID(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public void atualizarLivro(@PathVariable int id, @RequestBody Livro livro){
        try{
            service.atualizarLivro(livro, id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable int id){
        try{
            service.deletarLivro(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
