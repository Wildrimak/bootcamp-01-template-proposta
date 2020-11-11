package br.com.zup.proposta.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.proposta.domain.models.Proposta;
import br.com.zup.proposta.domain.models.StatusProposta;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {

	public Optional<Proposta> findByDocumento(String documento);

	public List<Proposta> findByNumeroDoCartaoIsNullAndStatusPropostaIs(StatusProposta statusProposta);

}
