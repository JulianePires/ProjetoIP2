package br.ufrpe.sistema_locadora.negocio.beans;

import java.time.LocalDate;

public class Cliente extends Pessoa {
	
	//ATRIBUTOS
	private String		cnh;
	private	String		telefone;
	
	//CONSTRUTOR COM HERANÇA
	public Cliente(String nome, String identificacao, LocalDate dataNasc, String logradouro, String bairro,
			String cidade, String uf, String cep, String email, String cnh, String telefone) {
		super(nome, identificacao, dataNasc, logradouro, bairro, cidade, uf, cep, email);
		
		setCnh(cnh);
		setTelefone(telefone);
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		if(cnh != null && cnh != "")
		this.cnh = cnh;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if(telefone != null && telefone != "")
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return super.toString() + " | CNH: "+cnh+" | Telefone: "+telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnh == null) ? 0 : cnh.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cnh == null) {
			if (other.cnh != null)
				return false;
		} else if (!cnh.equals(other.cnh))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	
	
}
