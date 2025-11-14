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

    public Lancamento criar(Long usuarioId, Lancamento novo) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        novo.setUsuario(usuario);
        return lancamentoRepository.save(novo);
    }

    public Lancamento editar(Long id, Lancamento atualizado) {
        Lancamento lancamento = buscarPorId(id);

        lancamento.setTitulo(atualizado.getTitulo());
        lancamento.setValor(atualizado.getValor());
        lancamento.setCategoria(atualizado.getCategoria());
        lancamento.setData(atualizado.getData());
        lancamento.setFormaPagamento(atualizado.getFormaPagamento());
        lancamento.setDescricao(atualizado.getDescricao());
        lancamento.setTipo(atualizado.getTipo());
        lancamento.setDespesaFixa(atualizado.getDespesaFixa());
        lancamento.setVencimento(atualizado.getVencimento());

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

    public void deletar(Long id) {
        lancamentoRepository.deleteById(id);
    }

    public Lancamento buscarPorId(Long id) {
        return lancamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lançamento não encontrado."));
    }
}
