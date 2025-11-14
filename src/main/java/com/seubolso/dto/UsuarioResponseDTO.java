package com.seubolso.dto;

import lombok.Data;

@Data
public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String fotoPerfil;

    private Double objetivoFinanceiro;
    private Double valorGuardado;

    private String dataCriacao;
}
