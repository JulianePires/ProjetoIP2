package br.ufrpe.sistema_locadora.negocio.beans;

public class Reboque {
	//ATRIBUTOS
	private static long		nextSerie = 1;
	private long		serie;
	private String		placa;
	private String		tipoCarga;
	private String		eixos;
	private	StatusEnum	status;
	private double		valorDiaria;
	/**
	 * @param serie
	 * @param placa
	 * @param tipoCarga
	 * @param eixos
	 * @param status
	 * @param valorDiaria
	 */
	public Reboque(long serie, String placa, String tipoCarga, String eixos, StatusEnum status, double valorDiaria) {
		super();
		this.serie = nextSerie;
		nextSerie++;
		setPlaca(placa);
		setTipoCarga(tipoCarga);
		setEixos(eixos);
		this.status = status;
		setValorDiaria(valorDiaria);
	}
	public long getSerie() {
		return serie;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipoCarga() {
		return tipoCarga;
	}
	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}
	public String getEixos() {
		return eixos;
	}
	public void setEixos(String eixos) {
		this.eixos = eixos;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	public double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

}
