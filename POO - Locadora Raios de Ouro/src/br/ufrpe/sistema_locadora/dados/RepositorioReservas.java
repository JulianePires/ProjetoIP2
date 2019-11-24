package br.ufrpe.sistema_locadora.dados;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.sistema_locadora.exceptions.ReboqueIndisponivelException;
import br.ufrpe.sistema_locadora.exceptions.ReservaNaoExisteException;
import br.ufrpe.sistema_locadora.negocio.beans.Reserva;

public class RepositorioReservas implements IRepositorioReservas {
	private List<Reserva> reservas;
	private static RepositorioReservas instance;
	
	private RepositorioReservas() {
		super();
		this.reservas = new ArrayList<>();
	}
	
	public static IRepositorioReservas getInstance() {
		if (instance == null) {
            instance = new RepositorioReservas();
        }
        return instance;
	}

	@Override
	public void cadastrar(Reserva r) throws ReboqueIndisponivelException {
		this.reservas.add(r);
	}

	@Override
	public void atualizar(Reserva r) {
		int indexReserva = this.reservas.indexOf(this.consultar(r.getCliente().getNome(), r.getDataHoraReserva()));
		this.reservas.set(indexReserva, r);
	}

	@Override
	public void remover(Reserva r) throws ReservaNaoExisteException {
		this.reservas.remove(this.reservas.indexOf(r));
	}

	@Override
	public Reserva consultar(String nomeCliente, LocalDateTime dataHora) {
		Reserva aux = null;
		for(Reserva r: this.reservas)
			if(r.getCliente().getNome().equals(nomeCliente) && r.getDataHoraReserva().equals(dataHora))
				aux = r;
		return aux;
	}

	@Override
	public boolean existe(String nomeCliente, LocalDateTime dataHora) {
		boolean answ = false;
		for(Reserva r: this.reservas)
			if(r.getCliente().getNome().equals(nomeCliente) && r.getDataHoraReserva().equals(dataHora))
				answ = true;
		return answ;
	}

	@Override
	public List<Reserva> listarTodas() {
		return this.reservas;
	}

	@Override
	public List<Reserva> listarPorData(LocalDate data) {
		List<Reserva> aux = new ArrayList<>();
		for(Reserva r: this.reservas)
			if(r.getDataHoraReserva().toLocalDate().equals(data))
				aux.add(r);
		return aux;
	}

	@Override
	public List<Reserva> listarPorCliente(String nomeCliente) {
		List<Reserva> aux = new ArrayList<>();
		for(Reserva r: this.reservas)
			if(r.getCliente().getNome().equals(nomeCliente))
				aux.add(r);
		return aux;
	}

	@Override
	public List<Reserva> listarPorReboque(long numSerieReboque) {
		List<Reserva> aux = new ArrayList<>();
		for(Reserva r: this.reservas)
			if(r.getReboque().getSerie() == numSerieReboque)
				aux.add(r);
		return aux;
	}
}
