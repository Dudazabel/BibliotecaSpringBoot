package com.example.Biblioteca.controller;

import com.example.Biblioteca.model.Usuario;
import com.example.Biblioteca.repository.UsuarioRepository;
import com.example.Biblioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/bibliotecaUsuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service){
        this.service = service;
    }

    @PostMapping
    public Usuario postUsuario(@RequestBody Usuario usuario){
        try{
            return service.cadastrarUsuario(usuario);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<Usuario> getListaUsuarios(){
        try{
            return service.listarUsuarios();
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Usuario getListaUsuarioID(@PathVariable int id){
        try{
            return service.listaUsuarioID(id);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public void putUsuario(@PathVariable int id, @RequestBody Usuario usuario){
        try{
            service.atualizarUsuario(usuario, id);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable int id){
        try {
            service.deletarUsuario(id);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }


}
