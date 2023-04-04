package org.senai.devinhouse.devinphilips.controllers;

import org.senai.devinhouse.devinphilips.models.Produto;
import org.senai.devinhouse.devinphilips.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    @RequestMapping("/new")
    public String newProdutoPage(Model model, Produto produto) {
        return "createProduto";
    }

    @GetMapping
    @RequestMapping("/all")
    public String showAllProducts(Model model) {
        List<Produto> produtos = produtoService.findAll();

        model.addAttribute("produtos", produtos);
        return "listProdutos";
    }


    @GetMapping
    public String showProduto(Model model) {
        Produto produto = Produto
                .builder()
                .nome("Teste")
                .descricao("Descrição Teste")
                .dataLancamento("01/01/2023")
                .preco(10D)
                .build();
        produtoService.addProduto(produto);

        model.addAttribute("produto", produto);

        return "produto";
    }

    @PostMapping
    public String createProduto(Model model, @Validated Produto produto){
        produtoService.addProduto(produto);

        return "redirect:produto/all";
    }
}
