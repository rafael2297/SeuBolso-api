package com.seubolso.controller;

import com.seubolso.dto.RegisterDTO;
import com.seubolso.model.Usuario;
import com.seubolso.security.JwtService;
import com.seubolso.service.UsuarioService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    // ============================
    // REGISTRO DE USUÁRIO
    // ============================
    @PostMapping("/register")
    public ResponseEntity<Usuario> registrar(@RequestBody RegisterDTO dto) {
        System.out.println("Recebido DTO: " + dto);
        Usuario novo = usuarioService.cadastrar(dto);
        return ResponseEntity.ok(novo);
    }

    @PostMapping("/teste")
    public ResponseEntity<String> teste(@RequestBody RegisterDTO dto) {
        System.out.println("Recebido: " + dto);
        return ResponseEntity.ok("OK");
    }

    // ============================
    // LOGIN
    // ============================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RegisterDTO dto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getSenha()));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(new TokenResponse(token));
    }

    // DTO para resposta do token
    record TokenResponse(String token) {
    }
}
