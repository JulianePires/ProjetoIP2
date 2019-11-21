package br.ufrpe.sistema_locadora.negocio;

import br.ufrpe.sistema_locadora.dados.IRepositorioClientes;
import br.ufrpe.sistema_locadora.exceptions.ClienteJaExisteException;
import br.ufrpe.sistema_locadora.exceptions.ClienteNaoExisteException;
import br.ufrpe.sistema_locadora.negocio.beans.Cliente;

public class ControladorClientes {
	private IRepositorioClientes repositorioClientes;
	
	public ControladorClientes(IRepositorioClientes instanciaRepositorio) {
		this.repositorioClientes = instanciaRepositorio;
	}
	
	public void cadastrar(Cliente c) throws ClienteJaExisteException{
		if(c == null) {
			throw new IllegalArgumentException("Parâmetro Inválido");
		} else {
			if (!this.repositorioClientes.existe(c.getNome())) {
                this.repositorioClientes.cadastrar(c);
            } else {
                throw new ClienteJaExisteException(c.getNome());
            }
		}
	}
	
	public void descadastrar(String nome) throws ClienteNaoExisteException {
    	Cliente c = this.repositorioClientes.consultar(nome);
    	if (c != null) {
    		this.repositorioClientes.remover(c);
		} else {
			throw new ClienteNaoExisteException(nome);
		}
    }
	
	public Cliente procurar(String cnh) {
        return this.repositorioClientes.consultar(cnh);
    }
    
    public boolean existe(String nome) {
    	return this.repositorioClientes.existe(nome);
    }

    public void remover(Cliente c) throws ClienteNaoExisteException {
        this.repositorioClientes.remover(c);
    }

}
