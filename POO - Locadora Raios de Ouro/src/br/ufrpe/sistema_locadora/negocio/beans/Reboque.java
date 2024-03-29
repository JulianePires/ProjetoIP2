package br.ufrpe.sistema_locadora.negocio.beans;

public class Reboque {
	//ATRIBUTOS
	private static long		nextSerie = 1;
	private long		serie;
	private String		placa;
	private Carga		tipoCarga;
	private int			eixos;
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
	public Reboque(long serie, String placa, Carga tipoCarga, int eixos, StatusEnum status, double valorDiaria) {
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
	public Carga getTipoCarga() {
		return tipoCarga;
	}
	public void setTipoCarga(Carga tipoCarga2) {
		this.tipoCarga = tipoCarga2;
	}
	public int getEixos() {
		return eixos;
	}
	public void setEixos(int eixos) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eixos;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + (int) (serie ^ (serie >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipoCarga == null) ? 0 : tipoCarga.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorDiaria);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Reboque other = (Reboque) obj;
		if (eixos != other.eixos)
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (serie != other.serie)
			return false;
		if (status != other.status)
			return false;
		if (tipoCarga != other.tipoCarga)
			return false;
		if (Double.doubleToLongBits(valorDiaria) != Double.doubleToLongBits(other.valorDiaria))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "|Número de Série: " + serie + " |Placa: " + placa + " |Tipo de Carga: " + tipoCarga + " |Quantidade de Eixos: " + eixos
				+ " |Status: " + status + " |Valor Diária: R$ " + valorDiaria + "]";
	}
	
	
	

}
