package br.ufrpe.sistema_locadora.dados;

import java.util.List;

import br.ufrpe.sistema_locadora.exceptions.ReboqueJaExisteException;
import br.ufrpe.sistema_locadora.exceptions.ReboqueNaoExisteException;
import br.ufrpe.sistema_locadora.negocio.beans.Carga;
import br.ufrpe.sistema_locadora.negocio.beans.Reboque;
import br.ufrpe.sistema_locadora.negocio.beans.StatusEnum;

public interface IRepositorioReboques {
	void cadastrar(Reboque r)throws ReboqueJaExisteException;
	void atualizar(Reboque r);
	void remover(Reboque r) throws ReboqueNaoExisteException;
	Reboque consultar(String placa, long numSerie);
	boolean existe(String placa);
	List<Reboque> listarTodos();
	List<Reboque> listarPorCarga(Carga carga);
	List<Reboque> listarPorStatus(StatusEnum status);
	List<Reboque> listarPorQuantidadeDeEixos(int eixos);
}
