package com.example.Biblioteca.dto.eprestimoDTO;

import java.time.LocalDate;

public record EmprestimoRequisicaoDTO(int idLivro,
                                      int idUsuario,
                                      LocalDate dataEmprestimo,
                                      LocalDate dataDevolucao) {
}
