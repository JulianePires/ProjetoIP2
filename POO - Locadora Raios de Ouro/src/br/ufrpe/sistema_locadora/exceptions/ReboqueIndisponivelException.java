package br.ufrpe.sistema_locadora.exceptions;

public class ReboqueIndisponivelException extends Exception {
	private long numSerie;

	public ReboqueIndisponivelException(long serie) {
		super("O Reboque de série: "+serie+" está indisponível para locação.");
		this.numSerie = serie;
	}

	public long getNumSerie() {
		return numSerie;
	}
}
