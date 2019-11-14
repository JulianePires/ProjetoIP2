package br.ufrpe.sistema_locadora.negocio.beans;

import java.time.LocalDateTime;

public class Reserva {
	//ATRIBUTOS
	private Reboque			reboque;
	private Cliente			cliente;
	private Usuario			usuario;
	private LocalDateTime	dataHoraReserva;
	private LocalDateTime	dataHoraLimite;
	
	public Reserva(Reboque reboque, Cliente cliente, Usuario usuario, LocalDateTime dataHoraReserva,
			LocalDateTime dataHoraLimite) {
		super();
		this.reboque = reboque;
		this.cliente = cliente;
		this.usuario = usuario;
		this.dataHoraReserva = dataHoraReserva;
		this.dataHoraLimite = dataHoraLimite;
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

	public LocalDateTime getDataHoraReserva() {
		return dataHoraReserva;
	}

	public void setDataHoraReserva(LocalDateTime dataHoraReserva) {
		this.dataHoraReserva = dataHoraReserva;
	}

	public LocalDateTime getDataHoraLimite() {
		return dataHoraLimite;
	}

	public void setDataHoraLimite(LocalDateTime dataHoraLimite) {
		this.dataHoraLimite = dataHoraLimite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dataHoraLimite == null) ? 0 : dataHoraLimite.hashCode());
		result = prime * result + ((dataHoraReserva == null) ? 0 : dataHoraReserva.hashCode());
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
		return "Reserva [reboque=" + reboque + ", cliente=" + cliente + ", usuario=" + usuario + ", dataHoraReserva="
				+ dataHoraReserva + ", dataHoraLimite=" + dataHoraLimite + "]";
	}
	
	
}
