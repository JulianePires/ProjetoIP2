package br.ufrpe.sistema_locadora.exceptions;

import java.time.LocalDateTime;

public class LocacaoNaoExisteException extends Exception {
	private String nomeCliente;
	private LocalDateTime dataHora;
	
	public LocacaoNaoExisteException(String nomeCliente, LocalDateTime dataHora) {
		super("A locação realizada pelo cliente "+nomeCliente+" no horário "+dataHora+" não existe.");
		this.nomeCliente = nomeCliente;
		this.dataHora = dataHora;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

}
