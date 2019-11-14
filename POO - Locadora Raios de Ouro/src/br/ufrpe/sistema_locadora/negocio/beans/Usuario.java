package br.ufrpe.sistema_locadora.negocio.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Usuario extends Pessoa {
	
	//ATRIBUTOS
	private	String 			login;
	private	String			senha;
	private	LocalDateTime	ultimoAcesso;
	private	boolean			ativo;
	private	Cargo			cargo;
	
	/**
	 * CONSTRUTOR COM HERANÇA
	 * @param nome
	 * @param identificacao
	 * @param dataNasc
	 * @param logradouro
	 * @param bairro
	 * @param cidade
	 * @param uf
	 * @param cep
	 * @param email
	 * @param login
	 * @param senha
	 * @param ultimoAcesso
	 * @param ativo
	 * @param cargo
	 */
	public Usuario(String nome, String identificacao, LocalDate dataNasc, String logradouro, String bairro,
			String cidade, String uf, String cep, String email, String login, String senha, LocalDateTime ultimoAcesso, boolean ativo, Cargo cargo) {
		super(nome, identificacao, dataNasc, logradouro, bairro, cidade, uf, cep, email);
		
		setLogin(login);
		setSenha(senha);
		setUltimoAcesso(ultimoAcesso);
		this.ativo = false;
		this.cargo = cargo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		if(login != null && login != "")
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if(senha != null && senha != "")
		this.senha = senha;
	}

	public LocalDateTime getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return super.toString() + " | Login: " + login + " | Último Acesso: " + ultimoAcesso + " | Ativo: " + ativo
				+ " | Cargo: " + cargo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((ultimoAcesso == null) ? 0 : ultimoAcesso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (ativo != other.ativo)
			return false;
		if (cargo != other.cargo)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (ultimoAcesso == null) {
			if (other.ultimoAcesso != null)
				return false;
		} else if (!ultimoAcesso.equals(other.ultimoAcesso))
			return false;
		return true;
	}
}
