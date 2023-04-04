package org.senai.devinhouse.devinphilips.controllers;

import org.senai.devinhouse.devinphilips.models.Produto;
import org.senai.devinhouse.devinphilips.repositories.ProdutoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public String showProduto(Model model) {
        Produto produto = Produto
                .builder()
                .nome("Teste")
                .descricao("Descrição Teste")
                .dataLancamento(Date.valueOf(LocalDate.now()))
                .preco(10D)
                .build();
        produtoRepository.save(produto);

        model.addAttribute("produto", produto);

        return "produto";
    }
}
