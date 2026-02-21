package com.example.Biblioteca.dto.eprestimoDTO;

import java.time.LocalDate;

public record EmprestimoRespostaDTO(int id,
                                    int idLivro,
                                    int idUsuario,
                                    LocalDate dataEmprestimo,
                                    LocalDate dataDevolucao) {
}
