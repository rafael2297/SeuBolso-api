package com.seubolso.service;

import com.seubolso.model.ListaDesejo;
import com.seubolso.model.Usuario;
import com.seubolso.repository.ListaDesejoRepository;
import com.seubolso.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaDesejoService {

    @Autowired
    private ListaDesejoRepository listaDesejoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ListaDesejo criar(Long usuarioId, ListaDesejo item) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        item.setUsuario(usuario);
        return listaDesejoRepository.save(item);
    }

    public List<ListaDesejo> listarPorUsuario(Long usuarioId) {
        return listaDesejoRepository.findByUsuarioId(usuarioId);
    }

    public ListaDesejo editar(Long id, ListaDesejo atualizado) {
        ListaDesejo item = buscarPorId(id);

        item.setDescricao(atualizado.getDescricao());
        item.setValorObjetivo(atualizado.getValorObjetivo());
        item.setValorAtual(atualizado.getValorAtual());
        item.setImagemBase64(atualizado.getImagemBase64());
        item.setLink(atualizado.getLink());

        return listaDesejoRepository.save(item);
    }

    public void deletar(Long id) {
        listaDesejoRepository.deleteById(id);
    }

    public ListaDesejo buscarPorId(Long id) {
        return listaDesejoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item da lista de desejos não encontrado."));
    }
}
