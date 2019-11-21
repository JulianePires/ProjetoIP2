package br.ufrpe.sistema_locadora.exceptions;

public class UsuarioNaoExisteException extends Exception {
	private String nomeInexistente;

	public UsuarioNaoExisteException(String name) {
		super("O Usuário: " + name + " não existe");
		this.nomeInexistente = name;
	}

	public String getNomeInexistente() {
		return nomeInexistente;
	}
}
