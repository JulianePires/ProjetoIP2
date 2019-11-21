package br.ufrpe.sistema_locadora.exceptions;

public class ClienteJaExisteException extends Exception {
	private String identificacao;

	  public ClienteJaExisteException(String id) {
		super("O cliente de CPF/CNPJ número: " + id + " já existe");
	    this.identificacao = id;
	  }

	  public String getIdentificacao() {
	    return identificacao;
	  }

}
