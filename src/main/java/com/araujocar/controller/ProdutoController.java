package com.araujocar.controller;

import com.araujocar.model.Produto;
import com.araujocar.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // POST /produtos
    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    // GET /produtos
    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    // GET /produtos/{id}
    @GetMapping("/{id}")
    public Optional<Produto> buscarPorId(@PathVariable Long id) {
        return produtoRepository.findById(id);
    }

    // DELETE /produtos/{id}
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}