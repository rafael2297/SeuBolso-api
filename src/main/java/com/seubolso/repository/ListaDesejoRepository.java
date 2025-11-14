package com.seubolso.repository;

import com.seubolso.model.ListaDesejo;
import com.seubolso.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListaDesejoRepository extends JpaRepository<ListaDesejo, Long> {

    List<ListaDesejo> findByUsuario(Usuario usuario);

    List<ListaDesejo> findByUsuarioId(Long usuarioId);
}
