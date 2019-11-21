package br.ufrpe.sistema_locadora.dados;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.ufrpe.sistema_locadora.exceptions.LocacaoNaoExisteException;
import br.ufrpe.sistema_locadora.exceptions.ReboqueIndisponivelException;
import br.ufrpe.sistema_locadora.negocio.beans.Locacao;

public interface IRepositorioLocacoes {
	void cadastrar(Locacao l) throws ReboqueIndisponivelException;
	void atualizar(Locacao l);
	void remover(Locacao l) throws LocacaoNaoExisteException;
	Locacao consultar(String nomeCliente, LocalDateTime dataHora);
	boolean existe(String nomeCliente, LocalDateTime dataHora);
	List<Locacao> listarTodas();
	List<Locacao> listarPorData(LocalDateTime dataHora);
	List<Locacao> listarPorCliente(String nomeCliente);
	List<Locacao> listarPorReboque(long numSerieReboque);
}
