package br.com.zup.proposta.api.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.NotReadablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.zup.proposta.api.dtos.responses.ErroResponse;

@RestControllerAdvice
public class PropostaControllerAdvice {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler
	public ResponseEntity<?> trataMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

		List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		List<ErroResponse> erroResponses = new ArrayList<>();
		// 1
		globalErrors.forEach(erro -> {
			String detalhes = getErrorMessage(erro);
			ErroResponse erroResponse = new ErroResponse("ErroGlobal", ErroResponse.Tipo.API, detalhes);
			erroResponses.add(erroResponse);
		});

		// 2
		fieldErrors.forEach(erro -> {
			String detalhes = getErrorMessage(erro);
			ErroResponse erroResponse = new ErroResponse(erro.getField(), ErroResponse.Tipo.API, detalhes);
			erroResponses.add(erroResponse);
		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroResponses);
	}

	@ExceptionHandler
	public ResponseEntity<?> trataNotReadablePropertyException(NotReadablePropertyException exception) {

		List<ErroResponse> erroResponses = new ArrayList<>();

		String detalhes = exception.getMessage();
		ErroResponse erroResponse = new ErroResponse("ErroGlobal", ErroResponse.Tipo.API, detalhes);
		erroResponses.add(erroResponse);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroResponses);
	}

	@ExceptionHandler
	public ResponseEntity<?> trataIllegalStateException(IllegalStateException exception) {

		List<ErroResponse> erroResponses = new ArrayList<>();

		String detalhes = exception.getMessage();
		ErroResponse erroResponse = new ErroResponse("ErroGlobal", ErroResponse.Tipo.NEGOCIO, detalhes);
		erroResponses.add(erroResponse);

		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erroResponses);
	}

	private String getErrorMessage(ObjectError error) {
		return messageSource.getMessage(error, LocaleContextHolder.getLocale());
	}

}
