package br.ufrpe.sistema_locadora.exceptions;

public class ReboqueNaoExisteException extends Exception {
	private long numSerieInexistente;

	public ReboqueNaoExisteException(long serie) {
		super("O Reboque de série: " + serie + " não existe");
		this.numSerieInexistente = serie;
	}

	public long getNumSerieInexistente() {
		return numSerieInexistente;
	}
}
