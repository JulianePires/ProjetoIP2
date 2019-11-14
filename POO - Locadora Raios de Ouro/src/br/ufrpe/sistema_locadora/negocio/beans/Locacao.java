package br.ufrpe.sistema_locadora.negocio.beans;

import java.time.LocalDateTime;

public class Locacao {
	//ATRIBUTOS
	private Reboque			reboque;
	private Cliente			cliente;
	private Usuario			usuario;
	private LocalDateTime	dataHora;
	private	int				numDiarias;
	private double			valorTotal;
	private	double			multa;
	private	double			valorFinal;
	
	public Locacao(Reboque reboque, Cliente cliente, Usuario usuario, LocalDateTime dataHora, int numDiarias,
			double valorTotal, double multa, double valorFinal) {
		super();
		this.reboque = reboque;
		this.cliente = cliente;
		this.usuario = usuario;
		this.dataHora = dataHora;
		this.numDiarias = numDiarias;
		this.valorTotal = valorTotal;
		this.multa = multa;
		this.valorFinal = valorFinal;
	}

	public Reboque getReboque() {
		return reboque;
	}

	public void setReboque(Reboque reboque) {
		this.reboque = reboque;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public int getNumDiarias() {
		return numDiarias;
	}

	public void setNumDiarias(int numDiarias) {
		this.numDiarias = numDiarias;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getMulta() {
		return multa;
	}

	public void setMulta(double multa) {
		this.multa = multa;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}

	@Override
	public String toString() {
		return "Locacao [reboque=" + reboque + ", cliente=" + cliente + ", usuario=" + usuario + ", dataHora="
				+ dataHora + ", numDiarias=" + numDiarias + ", valorTotal=" + valorTotal + ", multa=" + multa
				+ ", valorFinal=" + valorFinal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
		long temp;
		temp = Double.doubleToLongBits(multa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + numDiarias;
		result = prime * result + ((reboque == null) ? 0 : reboque.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		temp = Double.doubleToLongBits(valorFinal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorTotal);
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
		Locacao other = (Locacao) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
			return false;
		if (Double.doubleToLongBits(multa) != Double.doubleToLongBits(other.multa))
			return false;
		if (numDiarias != other.numDiarias)
			return false;
		if (reboque == null) {
			if (other.reboque != null)
				return false;
		} else if (!reboque.equals(other.reboque))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (Double.doubleToLongBits(valorFinal) != Double.doubleToLongBits(other.valorFinal))
			return false;
		if (Double.doubleToLongBits(valorTotal) != Double.doubleToLongBits(other.valorTotal))
			return false;
		return true;
	}
	
	
	
	

}
