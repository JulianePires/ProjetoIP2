package br.ufrpe.sistema_locadora.dados;

import java.util.List;

import br.ufrpe.sistema_locadora.exceptions.ClienteJaExisteException;
import br.ufrpe.sistema_locadora.exceptions.ClienteNaoExisteException;
import br.ufrpe.sistema_locadora.negocio.beans.Cliente;

public interface IRepositorioClientes {
	void cadastrar(Cliente c) throws ClienteJaExisteException;
	void atualizar(Cliente c) throws ClienteNaoExisteException;
	void remover(Cliente c) throws ClienteNaoExisteException;
	Cliente consultar(String nome);
	boolean existe(String nome);
	List<Cliente> listarTodos();
	
}
