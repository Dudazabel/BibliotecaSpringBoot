package com.example.Biblioteca.dto.usuarioDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequisicaoDTO(@NotNull(message = "O nome do Usuário não deve ser nulo!")
                                   String nome,
                                   @NotNull(message = "O email do Usuário não deve ser nulo!")
                                   @Email(message = "Digite um email válido!")
                                   String email) {
}
