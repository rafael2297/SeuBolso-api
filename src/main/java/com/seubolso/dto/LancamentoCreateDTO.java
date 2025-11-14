package com.seubolso.dto;

import lombok.Data;

@Data
public class LancamentoCreateDTO {

    private String titulo;
    private Double valor;
    private String categoria;
    private String data;
    private String formaPagamento;
    private String descricao;
    private String tipo; // receita | despesa
    private Boolean despesaFixa;
    private String vencimento;
}
