package br.ufrpe.sistema_locadora.negocio.beans;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {
	//ATRIBUTOS
	private	String		nome;
	private String		identificacao; //CPF-CNPJ
	private	LocalDate	dataNasc;
	private String		logradouro;
	private	String		bairro;
	private	String		cidade;
	private	String		uf;
	private	String		cep;
	private	String		email;
	
	/**
	 * CONSTRUTOR CLASSE ABSTRATA
	 * @param nome - NOME COMPLETO
	 * @param identificacao - CPF XXX.XXX.XXX-XX /CNPJ XX.XXX.XXX/XXXX-XX
	 * @param dataNasc - DATA DE NASCIMENTO
	 * @param logradouro - ENDEREÇO + NUM + COMPLEMENTO
	 * @param bairro - BAIRRO
	 * @param cidade - CIDADE
	 * @param uf - ESTADO
	 * @param cep - CODIGO POSTAL XX.XXX-XX
	 * @param email
	 */
	public Pessoa(String nome, String identificacao, LocalDate dataNasc, String logradouro, String bairro,
			String cidade, String uf, String cep, String email) {
		
		setNome(nome);
		setIdentificacao(identificacao);
		setDataNasc(dataNasc);
		setLogradouro(logradouro);
		setBairro(bairro);
		setCidade(cidade);
		setUf(uf);
		setCep(cep);
		setEmail(email);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome != null && nome != "")
		this.nome = nome;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		if(identificacao != null && identificacao != "")
		this.identificacao = identificacao;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		if(dataNasc.isAfter(LocalDate.now().minusYears(18))) //GARANTE QUE A PESSOA CADASTRADA SEJA MAIOR DE IDADE
		this.dataNasc = dataNasc;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		if(logradouro != null && logradouro != "")
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		if(bairro != null && bairro != "")
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		if(cidade != null && cidade != "")
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		if(uf != null && uf != "")
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		if(cep != null && cep != "")
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email != null && email != "")
		this.email = email;
	}

	@Override
	public String toString() {
		return "| Nome: " + nome + " | CPF/CNPJ: " + identificacao + " | Data de Nascimento: " + dataNasc + " | Logradouro: "
				+ logradouro + " | Bairro " + bairro + " | Cidade: " + cidade + " | UF: " + uf + " |CEP: " + cep + " | E-mail: "
				+ email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((dataNasc == null) ? 0 : dataNasc.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((identificacao == null) ? 0 : identificacao.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (dataNasc == null) {
			if (other.dataNasc != null)
				return false;
		} else if (!dataNasc.equals(other.dataNasc))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (identificacao == null) {
			if (other.identificacao != null)
				return false;
		} else if (!identificacao.equals(other.identificacao))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}
}
