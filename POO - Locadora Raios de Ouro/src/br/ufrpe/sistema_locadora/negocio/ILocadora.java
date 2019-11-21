package br.ufrpe.sistema_locadora.negocio;

import br.ufrpe.sistema_locadora.negocio.beans.Cliente;
import br.ufrpe.sistema_locadora.negocio.beans.Manutencao;
import br.ufrpe.sistema_locadora.negocio.beans.Reboque;
import br.ufrpe.sistema_locadora.negocio.beans.Usuario;

public interface ILocadora {
	void cadastrarCliente(Cliente c);
	void cadastrarReboque(Reboque r);
	void cadastrarUsuario(Usuario u);
	void cadastrarManutencao(Manutencao m);
	
	

}
