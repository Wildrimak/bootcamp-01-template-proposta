package br.com.zup.proposta.domain.services;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.proposta.domain.models.Bloqueio;
import br.com.zup.proposta.domain.repositories.BloqueioRepository;

@Service
public class BloquearCartaoService {

	@Autowired
	private BloqueioRepository bloqueioRepository;

	@Transactional
	public Bloqueio registrar(@NotNull Bloqueio bloqueio) {
		
		Integer quantidadeDeBloqueios = bloqueio.getCartao().quantidadeDeBloqueios();
		
		if (quantidadeDeBloqueios > 0) {
			throw new IllegalStateException("Esse cartão já foi bloqueado!");
		}
		
		return bloqueioRepository.save(bloqueio);
	}

}
