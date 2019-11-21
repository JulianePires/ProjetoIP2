package br.ufrpe.sistema_locadora.negocio.beans;

import java.time.LocalDateTime;

public class Reserva {
	//ATRIBUTOS
	private Reboque			reboque;
	private Cliente			cliente;
	private Usuario			usuario;
	private LocalDateTime	dataHoraReserva;
	private LocalDateTime	dataHoraLimite;
	private	int				numDiarias;
	
	public Reserva(Reboque reboque, Cliente cliente, Usuario usuario, LocalDateTime dataHoraReserva, int numDiarias) {
		super();
		setReboque(reboque);
		setCliente(cliente);
		setUsuario(usuario);
		this.dataHoraReserva = dataHoraReserva;
		setNumDiarias(numDiarias);
		setDataHoraLimite();
	}

	public int getNumDiarias() {
		return numDiarias;
	}

	public void setNumDiarias(int numDiarias) {
		if(numDiarias > 0)
		this.numDiarias = numDiarias;
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

	public LocalDateTime getDataHoraReserva() {
		return dataHoraReserva;
	}

	public void setDataHoraReserva(LocalDateTime dataHoraReserva) {
		this.dataHoraReserva = dataHoraReserva;
	}

	public LocalDateTime getDataHoraLimite() {
		return dataHoraLimite;
	}

	public void setDataHoraLimite() {
		this.dataHoraLimite = this.dataHoraReserva.plusDays(numDiarias);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dataHoraLimite == null) ? 0 : dataHoraLimite.hashCode());
		result = prime * result + ((dataHoraReserva == null) ? 0 : dataHoraReserva.hashCode());
		result = prime * result + numDiarias;
		result = prime * result + ((reboque == null) ? 0 : reboque.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Reserva other = (Reserva) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dataHoraLimite == null) {
			if (other.dataHoraLimite != null)
				return false;
		} else if (!dataHoraLimite.equals(other.dataHoraLimite))
			return false;
		if (dataHoraReserva == null) {
			if (other.dataHoraReserva != null)
				return false;
		} else if (!dataHoraReserva.equals(other.dataHoraReserva))
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
		return true;
	}

	@Override
	public String toString() {
		return "Reserva: |Número de Série Reboque: " + reboque.getSerie() + " |Cliente: " + cliente.getNome() + " |Usuario: " + usuario.getNome() + " |Data/Hora Reserva: "
				+ dataHoraReserva + " |Limite de Entrega: " + dataHoraLimite + " |Diárias: " + numDiarias;
	}

	
	
	
}
