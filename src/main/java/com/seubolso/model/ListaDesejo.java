package com.seubolso.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "lista_desejos")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListaDesejo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorObjetivo;

    @Column(precision = 10, scale = 2)
    private BigDecimal valorAtual = BigDecimal.ZERO;

    @Column(length = 500)
    private String link;

    @Lob
    private String imagemBase64;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
