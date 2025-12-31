package com.usuarios.GestaoDeUsuarios.controller;

import com.usuarios.GestaoDeUsuarios.model.Usuario;
import com.usuarios.GestaoDeUsuarios.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    // Criando um usuario
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioService.criarUsuario(usuario);
        return ResponseEntity.ok(usuarioSalvo);
    }
    // Listar todos os usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }
    // Listar por id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }
    // Atualizar usuarios
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(
            @PathVariable Long id,
            @RequestBody Usuario usuario) {

        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }
    // Desativar um usuario
    @PutMapping("/{id}/desativar")
    public ResponseEntity<Usuario> desativarUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.desativarUsuario(id));
    }
    // Ativar um usuario
    @PutMapping("/{id}/ativar")
    public ResponseEntity<Usuario> ativarUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.ativarUsuario(id));
    }

}
