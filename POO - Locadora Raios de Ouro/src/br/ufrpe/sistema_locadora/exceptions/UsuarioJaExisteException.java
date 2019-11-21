package br.ufrpe.sistema_locadora.exceptions;

public class UsuarioJaExisteException extends Exception {
	private String nome;

	public UsuarioJaExisteException(String name) {
		super("O Usuário: " + name + " já existe");
		this.nome = name;
	}

	public String getNome() {
		return nome;
	}
}
