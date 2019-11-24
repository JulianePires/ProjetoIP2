package br.ufrpe.sistema_locadora.dados;

import java.util.ArrayList;
import java.util.List;
import br.ufrpe.sistema_locadora.exceptions.UsuarioJaExisteException;
import br.ufrpe.sistema_locadora.exceptions.UsuarioNaoExisteException;
import br.ufrpe.sistema_locadora.negocio.beans.Cargo;
import br.ufrpe.sistema_locadora.negocio.beans.Usuario;

public class RepositorioUsuarios implements IRepositorioUsuarios {
	List<Usuario> usuarios;
	private static RepositorioUsuarios instance;

	private RepositorioUsuarios() {
		this.usuarios = new ArrayList<>();;
	}

	public static IRepositorioUsuarios getInstance() {
		if (instance == null) {
			instance = new RepositorioUsuarios();
		}
		return instance;
	}

	@Override
	public void cadastrar(Usuario u) throws UsuarioJaExisteException {
		this.usuarios.add(u);

	}

	@Override
	public void atualizar(Usuario u) throws UsuarioNaoExisteException {
		int indexUsuario = this.usuarios.indexOf(this.consultar(u.getNome(), u.getLogin()));
		this.usuarios.set(indexUsuario, u);
	}

	@Override
	public void remover(Usuario u) throws UsuarioNaoExisteException {
		this.usuarios.remove(this.usuarios.indexOf(u));
	}

	@Override
	public Usuario consultar(String nome, String login) {
		Usuario aux = null;
		for(Usuario u: this.usuarios) {
			if(u.getNome().equals(nome) && u.getLogin().equals(login))
				aux = u;
		}
		return aux;
	}

	@Override
	public boolean existe(String nome) {
		boolean answ = false;
		for(Usuario u: this.usuarios)
			if(u.getNome().equals(nome))
				answ = true;
		return answ;
	}

	@Override
	public List<Usuario> listarTodos() {
		return this.usuarios;
	}
	@Override
	public List<Usuario> listarPorCargo(Cargo cargo) {
		List<Usuario> aux = new ArrayList<>();
		for(Usuario u: this.usuarios)
			if(u.getCargo().equals(cargo))
				aux.add(u);
		return aux;
	}

	@Override
	public void desligarFuncionario(String nome, String login) {
		Usuario u = this.consultar(nome, login);
		if(u.getCargo().equals(Cargo.FUNCIONARIO))
			u.setAtivo(false);
	}
}
