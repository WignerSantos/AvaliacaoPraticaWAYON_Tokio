package com.avaliacao.exceptions;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 395789324727986640L;

	public BusinessException(String mensagem) {
        super(mensagem);
    }

}