package br.com.zup.proposta.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.proposta.domain.models.Biometria;

public interface BiometriaRepository extends JpaRepository<Biometria, String> {
}
