package com.seubolso.controller;

import com.seubolso.model.ListaDesejo;
import com.seubolso.service.ListaDesejoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lista-desejos")

public class ListaDesejoController {

    @Autowired
    private ListaDesejoService listaDesejoService;

    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<ListaDesejo> criar(
            @PathVariable Long usuarioId,
            @RequestBody ListaDesejo item
    ) {
        return ResponseEntity.ok(listaDesejoService.criar(usuarioId, item));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ListaDesejo>> listar(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(listaDesejoService.listarPorUsuario(usuarioId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaDesejo> atualizar(
            @PathVariable Long id,
            @RequestBody ListaDesejo item
    ) {
        return ResponseEntity.ok(listaDesejoService.editar(id, item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        listaDesejoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
