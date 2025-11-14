package com.seubolso.dto;

import lombok.Data;

@Data
public class ListaDesejosDTO {

    private Long id;
    private String descricao;
    private Double valorObjetivo;
    private Double valorAtual;
    private String link;
    private String imagemBase64;
    private String dataCriacao;
    private Long usuarioId;
}
