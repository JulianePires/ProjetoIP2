package br.ufrpe.sistema_locadora.negocio;

import java.util.List;

import br.ufrpe.sistema_locadora.dados.IRepositorioUsuarios;
import br.ufrpe.sistema_locadora.exceptions.UsuarioJaExisteException;
import br.ufrpe.sistema_locadora.exceptions.UsuarioNaoExisteException;
import br.ufrpe.sistema_locadora.negocio.beans.Cargo;
import br.ufrpe.sistema_locadora.negocio.beans.Usuario;

public class ControladorUsuarios {
	private IRepositorioUsuarios repositorioUsuarios;
	
	public ControladorUsuarios(IRepositorioUsuarios instanciaRepositorio) {
		this.repositorioUsuarios = instanciaRepositorio;
	}
	
	public void cadastrar(Usuario u) throws UsuarioJaExisteException {
		if(u == null) {
			throw new IllegalArgumentException("Parametro Invalido");
		} else {
			if(!this.repositorioUsuarios.existe(u.getNome())) {
				this.repositorioUsuarios.cadastrar(u);
			} else {
				throw new UsuarioJaExisteException(u.getNome());
			}
		}
	}
	
	public void descadastrar(Usuario u) throws UsuarioNaoExisteException{
		Usuario aux = this.repositorioUsuarios.consultar(u.getNome(), u.getLogin());
		if(aux != null) {
			this.repositorioUsuarios.remover(u);
		} else {
			throw new UsuarioNaoExisteException(u.getNome());
		}
	}
	
	public void atualizar(Usuario u) throws UsuarioNaoExisteException{
		if(this.repositorioUsuarios.existe(u.getNome())) {
			this.repositorioUsuarios.atualizar(u);
		} else {
			throw new UsuarioNaoExisteException(u.getNome());
		}
	}
	
	public Usuario procurar(String nome, String login) {
		return this.repositorioUsuarios.consultar(nome, login);
	}
	
	public boolean existe(Usuario u) {
		return this.repositorioUsuarios.existe(u.getNome());
	}
	
	public List<Usuario> listar(){
		return this.repositorioUsuarios.listarTodos();
	}
	
	public List<Usuario> listarPorCargo(Cargo cargo){
		return this.listarPorCargo(cargo);
	}
	
	public void desligarFuncionario(String nome, String login) throws UsuarioNaoExisteException {
		Usuario u = this.repositorioUsuarios.consultar(nome, login);
		if(u != null) {
			this.repositorioUsuarios.desligarFuncionario(nome, login);
		} else {
			throw new UsuarioNaoExisteException(nome);
		}
	}
}
