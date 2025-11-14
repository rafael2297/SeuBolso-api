package com.seubolso.dto;

import lombok.Data;

@Data
public class UsuarioUpdateDTO {

    private String nome;
    private String fotoPerfil; // base64
    private Double objetivoFinanceiro;
    private Double valorGuardado;
}
