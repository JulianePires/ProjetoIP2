package br.ufrpe.sistema_locadora.dados;

import java.time.LocalDateTime;
import java.util.List;

import br.ufrpe.sistema_locadora.exceptions.ReboqueIndisponivelException;
import br.ufrpe.sistema_locadora.negocio.beans.Manutencao;
import br.ufrpe.sistema_locadora.negocio.beans.Reboque;

public interface IRepositorioManutencoes {
	void cadastrar(Manutencao m)throws ReboqueIndisponivelException;
	void atualizar(Manutencao m);
	void remover(Manutencao m);
	Manutencao consultar(long numSerieReboque, LocalDateTime dataHora, String servico);
	boolean existe(long numSerieReboque);
	List<Manutencao> listarTodos();
	List<Manutencao> listarPorServico(String servico);
	List<Manutencao> listarPorDataHora(LocalDateTime dataHora);
	List<Manutencao> listarPorReboque(Reboque r);

}
