package br.com.zup.proposta.domain.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.proposta.domain.models.Aviso;
import br.com.zup.proposta.domain.repositories.AvisoRepository;

@Service
public class CadastrarAvisoDeViagemService {

	@Autowired
	private AvisoRepository avisoRepository;

	@Transactional
	public Aviso cadastrar(Aviso aviso) {

		Aviso save = avisoRepository.save(aviso);

		return save;
	}

}
