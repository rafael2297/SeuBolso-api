package com.seubolso.service;

import com.seubolso.model.Lancamento;
import com.seubolso.model.Usuario;
import com.seubolso.repository.LancamentoRepository;
import com.seubolso.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Lancamento criar(Long usuarioId, Lancamento lancamento) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        lancamento.setUsuario(usuario);
        return lancamentoRepository.save(lancamento);
    }

    public List<Lancamento> listarPorUsuario(Long usuarioId) {
        return lancamentoRepository.findByUsuarioId(usuarioId);
    }

    public List<Lancamento> listarPorPeriodo(Long usuarioId, LocalDate inicio, LocalDate fim) {
        return lancamentoRepository.findByUsuarioIdAndDataBetween(usuarioId, inicio, fim);
    }

    public List<Lancamento> listarPorTipo(Long usuarioId, Lancamento.TipoLancamento tipo) {
        return lancamentoRepository.findByUsuarioIdAndTipo(usuarioId, tipo);
    }

    public List<Lancamento> listarDespesasFixas(Long usuarioId) {
        return lancamentoRepository.findByDespesaFixaTrueAndUsuarioId(usuarioId);
    }

    public Lancamento editar(Long id, Lancamento atualizado) {
        Lancamento lanc = lancamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lançamento não encontrado."));

        lanc.setTitulo(atualizado.getTitulo());
        lanc.setValor(atualizado.getValor());
        lanc.setCategoria(atualizado.getCategoria());
        lanc.setData(atualizado.getData());
        lanc.setFormaPagamento(atualizado.getFormaPagamento());
        lanc.setDescricao(atualizado.getDescricao());
        lanc.setTipo(atualizado.getTipo());
        lanc.setDespesaFixa(atualizado.getDespesaFixa());
        lanc.setVencimento(atualizado.getVencimento());

        return lancamentoRepository.save(lanc);
    }

    public void deletar(Long id) {
        lancamentoRepository.deleteById(id);
    }
}
