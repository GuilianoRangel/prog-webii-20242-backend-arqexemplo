/*
 * SistemaMessageCode.java
 * Copyright (c) UEG.
 */
package br.ueg.progweb2.arqexemplo.exceptions;

import br.ueg.progweb2.arquitetura.exceptions.MessageCode;

/**
 * Enum com os código de exceções/mensagens de negócio.
 * 
 * @author UEG S/A.
 */
public enum AppMessageCode implements MessageCode {
	REGISTER_NUMBER_DUPLICATED("MSG-001", 400),
	REGISTER_NUMBER_INVALID("MSG-002", 100),
	TASK_ALREADY_COMPLETED("MSG-003", 200),
	CATEGORY_NAME_DUPLICATED("MSG-004", 400);

	private final String code;

	private final Integer status;

	/**
	 * Construtor da classe.
	 *
	 * @param code -
	 * @param status -
	 */
	AppMessageCode(final String code, final Integer status) {
		this.code = code;
		this.status = status;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @see Enum#toString()
	 */
	@Override
	public String toString() {
		return code;
	}
}
