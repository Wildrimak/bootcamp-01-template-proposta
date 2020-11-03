package br.com.zup.proposta.api.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.proposta.api.dtos.requests.PropostaRequest;

@Component
public class CpfCnpjValidator implements Validator {

	@Override // 1
	public boolean supports(Class<?> clazz) {
		return PropostaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		// 1
		if (errors.hasErrors()) {
			return;
		}

		PropostaRequest request = (PropostaRequest) target;

		// 1
		if (!request.documentoValido()) {
			errors.rejectValue("documento", null, "O documento precisa ser cpf ou cnpj válido");
		}

	}

}
