package com.seubolso.controller;

import com.seubolso.model.Lancamento;
import com.seubolso.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/lancamentos")
@CrossOrigin("*")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<Lancamento> criar(
            @PathVariable Long usuarioId,
            @RequestBody Lancamento lancamento
    ) {
        return ResponseEntity.ok(lancamentoService.criar(usuarioId, lancamento));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Lancamento>> listar(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(lancamentoService.listarPorUsuario(usuarioId));
    }

    @GetMapping("/usuario/{usuarioId}/periodo")
    public ResponseEntity<List<Lancamento>> listarPorPeriodo(
            @PathVariable Long usuarioId,
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim
    ) {
        return ResponseEntity.ok(lancamentoService.listarPorPeriodo(usuarioId, inicio, fim));
    }

    @GetMapping("/usuario/{usuarioId}/tipo/{tipo}")
    public ResponseEntity<List<Lancamento>> listarPorTipo(
            @PathVariable Long usuarioId,
            @PathVariable Lancamento.TipoLancamento tipo
    ) {
        return ResponseEntity.ok(lancamentoService.listarPorTipo(usuarioId, tipo));
    }

    @GetMapping("/usuario/{usuarioId}/fixas")
    public ResponseEntity<List<Lancamento>> despesasFixas(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(lancamentoService.listarDespesasFixas(usuarioId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lancamento> atualizar(
            @PathVariable Long id,
            @RequestBody Lancamento lancamento
    ) {
        return ResponseEntity.ok(lancamentoService.editar(id, lancamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        lancamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
