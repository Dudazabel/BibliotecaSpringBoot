package com.example.Biblioteca.dto.livroDTO;

import jakarta.validation.constraints.NotNull;

public record LivroRequisicaoDTO(@NotNull(message = "O título do Livro não deve ser nulo!")
                                 String titulo,
                                 @NotNull(message = "O autor do Livro não deve ser nulo!")
                                 String autor,
                                 @NotNull(message = "O ano de publicação do Livro não deve ser nulo!")
                                 int anoPublicacao) {
}
