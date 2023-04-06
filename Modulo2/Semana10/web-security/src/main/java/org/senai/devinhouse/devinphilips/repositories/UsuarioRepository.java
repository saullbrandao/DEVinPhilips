package org.senai.devinhouse.devinphilips.repositories;

import org.senai.devinhouse.devinphilips.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
