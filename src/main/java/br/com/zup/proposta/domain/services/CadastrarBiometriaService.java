package br.com.zup.proposta.domain.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.proposta.domain.models.Biometria;
import br.com.zup.proposta.domain.repositories.BiometriaRepository;

@Service
public class CadastrarBiometriaService {

	@Autowired
	private BiometriaRepository biometriaRepository;
	
	@Transactional
	public Biometria salvar(Biometria biometria) {
		return biometriaRepository.save(biometria);
	}

}
