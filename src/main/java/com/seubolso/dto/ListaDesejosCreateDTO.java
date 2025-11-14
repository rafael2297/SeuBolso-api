package com.seubolso.dto;

import lombok.Data;

@Data
public class ListaDesejosCreateDTO {

    private String descricao;
    private Double valorObjetivo;
    private Double valorAtual;
    private String link;
    private String imagemBase64;
}
