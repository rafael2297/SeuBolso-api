package com.seubolso.service;

import com.seubolso.dto.RegisterDTO;
import com.seubolso.model.Usuario;
import com.seubolso.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    // ============================================
    // LOGIN → usado pelo Spring Security / JWT
    // ============================================
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + email));

        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getEmail())
                .password(usuario.getSenha())
                .roles("USER")
                .build();
    }

    // ============================================
    // CADASTRAR NOVO USUÁRIO (USANDO DTO)
    // ============================================
    public Usuario cadastrar(RegisterDTO dto) {

        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("E-mail já está em uso.");
        }

        Usuario usuario = Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(passwordEncoder.encode(dto.getSenha()))
                .role("USER") // valor default para perfil
                .saldo(BigDecimal.ZERO) // inicializa saldo com 0
                .meta(BigDecimal.ZERO) // inicializa meta com 0
                .objetivoFinanceiro(BigDecimal.ZERO) // inicializa objetivo
                .valorGuardado(BigDecimal.ZERO) // inicializa valor guardado
                .build();

        return usuarioRepository.save(usuario);
    }

    // ============================================
    // EDITAR PERFIL
    // ============================================
    public Usuario editar(Long id, Usuario atualizado) {

        Usuario usuario = buscarPorId(id);

        usuario.setNome(atualizado.getNome());
        usuario.setFotoPerfil(atualizado.getFotoPerfil());
        usuario.setObjetivoFinanceiro(atualizado.getObjetivoFinanceiro());
        usuario.setValorGuardado(atualizado.getValorGuardado());

        return usuarioRepository.save(usuario);
    }

    // ============================================
    // BUSCAR POR ID
    // ============================================
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }

    // ============================================
    // BUSCAR POR EMAIL
    // ============================================
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }
}
