package org.senai.devinhouse.devinphilips.services;

import org.senai.devinhouse.devinphilips.models.Produto;
import org.senai.devinhouse.devinphilips.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void addProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
}
