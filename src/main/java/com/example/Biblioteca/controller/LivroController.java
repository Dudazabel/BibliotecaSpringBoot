package com.example.Biblioteca.controller;

import com.example.Biblioteca.dto.livroDTO.LivroRequisicaoDTO;
import com.example.Biblioteca.dto.livroDTO.LivroRespostaDTO;
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
    public LivroRespostaDTO postLivro (@RequestBody LivroRequisicaoDTO livroDTO) {
        try{
            return service.cadastrarLivro(livroDTO);

        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<LivroRespostaDTO> getListaLivro(){
        try{
            return service.listaLivros();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public LivroRespostaDTO getListaLivroID(@PathVariable int id){
        try{
            return service.listaLivroID(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public void atualizarLivro(@PathVariable int id, @RequestBody LivroRequisicaoDTO livroDTO){
        try{
            service.atualizarLivro(livroDTO, id);
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
