package br.com.quadro.secretario.repository;

import br.com.quadro.secretario.entidades.Publicador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicadorRepository extends JpaRepository<Publicador, Long> {
}
