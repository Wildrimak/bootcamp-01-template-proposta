package br.com.zup.proposta.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.proposta.domain.models.Aviso;

public interface AvisoRepository extends JpaRepository<Aviso, String> {

}
