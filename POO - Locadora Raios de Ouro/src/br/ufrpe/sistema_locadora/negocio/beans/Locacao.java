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

	public Locacao(Reboque reboque, Cliente cliente, Usuario usuario, LocalDateTime dataHora, int numDiarias, double multa) {
		super();
		setReboque(reboque);
		setCliente(cliente);
		setUsuario(usuario);
		setDataHora(dataHora);
		setNumDiarias(numDiarias);
		setMulta(multa);
		setValorTotal();
	}

	public Reboque getReboque() {
		return reboque;
	}

	public void setReboque(Reboque reboque) {
		if(reboque != null)
			this.reboque = reboque;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		if(cliente != null)
			this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		if(usuario != null)
			this.usuario = usuario;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		if(dataHora == null) {
			this.dataHora = LocalDateTime.now();
		}else
			this.dataHora = dataHora;
	}

	public int getNumDiarias() {
		return numDiarias;
	}

	public void setNumDiarias(int numDiarias) {
		if(numDiarias > 0)
			this.numDiarias = numDiarias;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal() {
		this.valorTotal = numDiarias*this.reboque.getValorDiaria()+this.multa;
	}

	public double getMulta() {
		return multa;
	}

	public void setMulta(double multa) {
		if(multa >= 0)
			this.multa = multa;
	}

	@Override
	public String toString() {
		return "Locacao: |Número de Série Reboque: " + reboque.getSerie() + " |Cliente: " + cliente.getNome() + " |Funcionário Responsável: " + usuario.getNome() + " |Data/Hora Locação: "
				+ dataHora + " |Diárias: " + numDiarias + " |Valor Total: R$ " + valorTotal + " |Multa: R$ " + multa;
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
		if (Double.doubleToLongBits(valorTotal) != Double.doubleToLongBits(other.valorTotal))
			return false;
		return true;
	}





}
