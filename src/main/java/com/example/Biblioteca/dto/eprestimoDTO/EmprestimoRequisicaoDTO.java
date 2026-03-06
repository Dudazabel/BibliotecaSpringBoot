package com.example.Biblioteca.dto.eprestimoDTO;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EmprestimoRequisicaoDTO(@NotNull(message = "O id de Livro do Empréstimo não deve ser nulo!")
                                      int idLivro,
                                      @NotNull(message = "O id de usuário do Empréstimo não deve ser nulo!")
                                      int idUsuario,
                                      @NotNull(message = "A data de Empréstimo não deve ser nula!")
                                      LocalDate dataEmprestimo,
                                      @NotNull(message = "A data de devolução do Empréstimo não deve ser nula!")
                                      LocalDate dataDevolucao) {
}
