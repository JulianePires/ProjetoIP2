package br.ufrpe.sistema_locadora.negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.ufrpe.sistema_locadora.dados.IRepositorioReservas;
import br.ufrpe.sistema_locadora.exceptions.ReboqueIndisponivelException;
import br.ufrpe.sistema_locadora.exceptions.ReservaNaoExisteException;
import br.ufrpe.sistema_locadora.negocio.beans.Reserva;

public class ControladorReservas {
	private IRepositorioReservas repositorioReservas;
	
	public ControladorReservas(IRepositorioReservas instanciaRepositorio) {
		this.repositorioReservas = instanciaRepositorio;
	}
	
	public void cadastrar(Reserva r) throws ReboqueIndisponivelException{
		
	}
	public void atualizar(Reserva r) {
		
	}
	public void remover(Reserva r) throws ReservaNaoExisteException{
		
	}
	public Reserva consultar(String nomeCliente, LocalDateTime dataHora) {
		
	}
	public boolean existe(String nomeCliente, LocalDateTime dataHora) {
		
	}
	public List<Reserva> listarTodas(){
		
	}
	public List<Reserva> listarPorData(LocalDate data){
		
	}
	public List<Reserva> listarPorCliente(String nomeCliente){
		
	}
	public List<Reserva> listarPorReboque(long numSerieReboque){
		
	}
}
