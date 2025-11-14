package com.seubolso.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor     
@AllArgsConstructor
public class RegisterDTO {
    private String nome;
    private String email;
    private String senha;
}
