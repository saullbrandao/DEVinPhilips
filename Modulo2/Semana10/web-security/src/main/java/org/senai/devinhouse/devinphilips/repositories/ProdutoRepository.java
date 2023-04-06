package org.senai.devinhouse.devinphilips.repositories;

import org.senai.devinhouse.devinphilips.models.Produto;
import org.senai.devinhouse.devinphilips.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public List<Produto> findByUsuario(Usuario usuario);
}
