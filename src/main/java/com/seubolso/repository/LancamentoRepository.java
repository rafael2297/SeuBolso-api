package com.seubolso.repository;

import com.seubolso.model.Lancamento;
import com.seubolso.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    List<Lancamento> findByUsuario(Usuario usuario);

    List<Lancamento> findByUsuarioId(Long usuarioId);

    List<Lancamento> findByUsuarioIdAndDataBetween(Long usuarioId, LocalDate inicio, LocalDate fim);

    List<Lancamento> findByUsuarioIdAndTipo(Long usuarioId, Lancamento.TipoLancamento tipo);

    List<Lancamento> findByDespesaFixaTrueAndUsuarioId(Long usuarioId);
}
