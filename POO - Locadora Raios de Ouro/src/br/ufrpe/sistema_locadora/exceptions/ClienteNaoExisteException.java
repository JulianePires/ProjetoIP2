package br.ufrpe.sistema_locadora.exceptions;

public class ClienteNaoExisteException extends Exception {
	private String idInexistente;

	  public ClienteNaoExisteException(String id) {
	    super("O cliente de CPF/CNPJ número: " + id + " não existe");
	    this.idInexistente = id;
	  }

	  public String getNumeroInexistente() {
	    return idInexistente;
	  }

}
