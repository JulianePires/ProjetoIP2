package br.ufrpe.sistema_locadora.dados;

import java.util.List;
import br.ufrpe.sistema_locadora.exceptions.UsuarioJaExisteException;
import br.ufrpe.sistema_locadora.exceptions.UsuarioNaoExisteException;
import br.ufrpe.sistema_locadora.negocio.beans.Cargo;
import br.ufrpe.sistema_locadora.negocio.beans.Usuario;

public interface IRepositorioUsuarios {
	void cadastrar(Usuario u)throws UsuarioJaExisteException;
	void atualizar(Usuario u) throws UsuarioNaoExisteException;
	void remover(Usuario u) throws UsuarioNaoExisteException;
	Usuario consultar(String nome, String login);
	boolean existe(String nome);
	List<Usuario> listarTodos();
	List<Usuario> listarPorCargo(Cargo cargo);
}
