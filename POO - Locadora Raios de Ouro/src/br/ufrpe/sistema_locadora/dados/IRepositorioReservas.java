package br.ufrpe.sistema_locadora.dados;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import br.ufrpe.sistema_locadora.exceptions.ReboqueIndisponivelException;
import br.ufrpe.sistema_locadora.exceptions.ReservaNaoExisteException;
import br.ufrpe.sistema_locadora.negocio.beans.Reserva;

public interface IRepositorioReservas {
	void cadastrar(Reserva r) throws ReboqueIndisponivelException;
	void atualizar(Reserva r);
	void remover(Reserva r) throws ReservaNaoExisteException;
	Reserva consultar(String nomeCliente, LocalDateTime dataHora);
	boolean existe(String nomeCliente, LocalDateTime dataHora);
	List<Reserva> listarTodas();
	List<Reserva> listarPorData(LocalDate data);
	List<Reserva> listarPorCliente(String nomeCliente);
	List<Reserva> listarPorReboque(long numSerieReboque);
}
