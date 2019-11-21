package br.ufrpe.sistema_locadora.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.sistema_locadora.exceptions.ClienteJaExisteException;
import br.ufrpe.sistema_locadora.exceptions.ClienteNaoExisteException;
import br.ufrpe.sistema_locadora.negocio.beans.Cliente;

public class RepositorioClientes implements IRepositorioClientes{
	private List<Cliente>  clientes;
	private static RepositorioClientes instance;

	private RepositorioClientes() {
		this.clientes = new ArrayList<>();
	}
	
	public static IRepositorioClientes getInstance() {
        if (instance == null) {
            instance = new RepositorioClientes();
        }
        return instance;
    }

	@Override
	public void cadastrar(Cliente c) throws ClienteJaExisteException {
		this.clientes.add(c);
	}

	@Override
	public void atualizar(Cliente c) throws ClienteNaoExisteException {
		int indexCliente = this.clientes.indexOf(this.consultar(c.getCnh()));
		this.clientes.set(indexCliente, c);
		
	}

	@Override
	public void remover(Cliente c) throws ClienteNaoExisteException {
		this.clientes.remove(this.clientes.indexOf(c));
	}

	@Override
	public Cliente consultar(String nome) {
		Cliente aux = null;
		for(Cliente c: this.clientes) {
			if(c.getNome().equals(nome))
				aux = c;
		}
		return aux;
	}

	@Override
	public boolean existe(String nome) {
		boolean answ = false;
		for(Cliente c: this.clientes) {
			if(c.getNome().equals(nome))
				answ = true;
		}
		return answ;
	}

	@Override
	public List<Cliente> listarTodos() {
		return this.clientes;
	}	
	
}
