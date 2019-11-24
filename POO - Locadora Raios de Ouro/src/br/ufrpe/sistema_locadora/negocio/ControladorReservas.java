package br.ufrpe.sistema_locadora.negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.ufrpe.sistema_locadora.dados.IRepositorioReservas;
import br.ufrpe.sistema_locadora.exceptions.ReboqueIndisponivelException;
import br.ufrpe.sistema_locadora.exceptions.ReservaNaoExisteException;
import br.ufrpe.sistema_locadora.negocio.beans.Reserva;
import br.ufrpe.sistema_locadora.negocio.beans.StatusEnum;

public class ControladorReservas {
	private IRepositorioReservas repositorioReservas;

	public ControladorReservas(IRepositorioReservas instanciaRepositorio) {
		this.repositorioReservas = instanciaRepositorio;
	}

	public void cadastrar(Reserva r) throws ReboqueIndisponivelException{
		if(r == null) {
			throw new IllegalArgumentException("Parâmetro Inválido");
		} else {
			if(!this.repositorioReservas.existe(r.getCliente().getNome(), r.getDataHoraReserva())){
				if(r.getReboque().getStatus().equals(StatusEnum.DISPONIVEL)) {
					r.getReboque().setStatus(StatusEnum.RESERVADO);
					this.repositorioReservas.cadastrar(r);
				}else {
					throw new ReboqueIndisponivelException(r.getReboque().getSerie());
				} 
			}else {
				this.repositorioReservas.atualizar(r);
			}
		}
	}
	
	public void atualizar(Reserva r) {
		this.repositorioReservas.atualizar(r);
	}
	
	public void descadastrar(Reserva r) throws ReservaNaoExisteException{
		Reserva aux = this.repositorioReservas.consultar(r.getCliente().getNome(), r.getDataHoraReserva());
		if(aux != null) {
			this.repositorioReservas.remover(r);
		} else {
			throw new ReservaNaoExisteException(r.getCliente().getNome(), r.getDataHoraReserva());
		}
	}
	
	public Reserva procurar(String nomeCliente, LocalDateTime dataHora) {
		return this.repositorioReservas.consultar(nomeCliente, dataHora);
	}
	
	public boolean existe(String nomeCliente, LocalDateTime dataHora) {
		return this.repositorioReservas.existe(nomeCliente, dataHora);
	}
	
	public List<Reserva> listarTodas(){
		return this.repositorioReservas.listarTodas();
	}
	
	public List<Reserva> listarPorData(LocalDate data){
		return this.listarPorData(data);
	}
	
	public List<Reserva> listarPorCliente(String nomeCliente){
		return this.repositorioReservas.listarPorCliente(nomeCliente);
	}
	
	public List<Reserva> listarPorReboque(long numSerieReboque){
		return this.listarPorReboque(numSerieReboque);
	}
	
	
}
