package br.ufrpe.sistema_locadora.negocio.beans;

import java.time.LocalDateTime;

public class Manutencao {
	//ATRIBUTOS
	private Reboque			reboque;
	private String			tipoServico;
	private	String			descricao;
	private	String			local;
	private LocalDateTime	dataHora;
	private double			valor;
	/**
	 * @param reboque
	 * @param tipoServico
	 * @param descricao
	 * @param local
	 * @param dataHora
	 * @param valor
	 */
	public Manutencao(Reboque reboque, String tipoServico, String descricao, String local, LocalDateTime dataHora,
			double valor) {
		super();
		setReboque(reboque);
		setTipoServico(tipoServico);
		setDescricao(descricao);
		setLocal(local);
		this.dataHora = dataHora;
		setValor(valor);
	}
	public Reboque getReboque() {
		return reboque;
	}
	public void setReboque(Reboque reboque) {
		if(reboque != null)
		this.reboque = reboque;
	}
	public String getTipoServico() {
		return tipoServico;
	}
	public void setTipoServico(String tipoServico) {
		if(tipoServico != null && tipoServico != "")
		this.tipoServico = tipoServico;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		if(descricao != null && descricao != "")
		this.descricao = descricao;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		if(local != null && local != "")
		this.local = local;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		if(valor >= 0)
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Manutencao: |Número de Série Reboque: " + reboque.getSerie() + " |Serviço: " + tipoServico + " |Descricao: " + descricao
				+ " |Local: " + local + " Data/Hora: " + dataHora + " |Valor: R$ " + valor;
	}
	
	
}
