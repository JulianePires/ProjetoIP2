package br.ufrpe.sistema_locadora.exceptions;

public class ReboqueJaExisteException extends Exception {
	private long numSerie;

	public ReboqueJaExisteException(long serie) {
		super("O Reboque de série: " + serie + " já existe");
		this.numSerie = serie;
	}

	public long getNumSerie() {
		return numSerie;
	}
}
