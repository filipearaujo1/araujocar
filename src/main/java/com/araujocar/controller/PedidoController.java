package com.araujocar.controller;

import com.araujocar.model.Pedido;
import com.araujocar.repository.PedidoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // POST /pedidos
    @PostMapping
    public Pedido cadastrar(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // GET /pedidos
    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    // GET /pedidos/{id}
    @GetMapping("/{id}")
    public Optional<Pedido> buscarPorId(@PathVariable Long id) {
        return pedidoRepository.findById(id);
    }

    // DELETE /pedidos/{id}
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }
}