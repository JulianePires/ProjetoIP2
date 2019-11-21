package br.ufrpe.sistema_locadora.negocio;

import java.util.List;

import br.ufrpe.sistema_locadora.dados.IRepositorioReboques;
import br.ufrpe.sistema_locadora.exceptions.ReboqueJaExisteException;
import br.ufrpe.sistema_locadora.exceptions.ReboqueNaoExisteException;
import br.ufrpe.sistema_locadora.negocio.beans.Carga;
import br.ufrpe.sistema_locadora.negocio.beans.Reboque;
import br.ufrpe.sistema_locadora.negocio.beans.StatusEnum;

public class ControladorReboques {
	private IRepositorioReboques repositorioReboques;
	
	public ControladorReboques(IRepositorioReboques instanciaRepositorio) {
		this.repositorioReboques = instanciaRepositorio;
	}
	
	public void cadastrar(Reboque r) throws ReboqueJaExisteException {
		if(r == null) {
			throw new IllegalArgumentException("Parâmetro Inválido");
		} else {
			if (!this.repositorioReboques.existe(r.getPlaca())) {
				this.repositorioReboques.cadastrar(r);
			} else {
				throw new ReboqueJaExisteException(r.getSerie());
			}
		}
	}
	
	public void descadastrar(String placa, long numSerie) throws ReboqueNaoExisteException{
		Reboque r = this.repositorioReboques.consultar(placa, numSerie);
		if(r != null) {
			this.repositorioReboques.remover(r);
		} else {
			throw new ReboqueNaoExisteException(numSerie);
		}
	}
	
	public void atualizar(String placa, long numSerie) throws ReboqueNaoExisteException{
		Reboque r = this.repositorioReboques.consultar(placa, numSerie);
		if(r != null) {
			this.repositorioReboques.atualizar(r);
		} else {
			throw new ReboqueNaoExisteException(numSerie);
		}
	}
	
	public Reboque pesquisar(String placa, long numSerie) {
		return this.repositorioReboques.consultar(placa, numSerie);
	}
	
	public boolean existe(String placa) {
		return this.repositorioReboques.existe(placa);
	}
	
	public List<Reboque> listar(){
		return this.repositorioReboques.listarTodos();
	}
	
	public List<Reboque> listarPorStatus(StatusEnum status){
		return this.repositorioReboques.listarPorStatus(status);
	}
	
	public List<Reboque> listarPorQuantidadeDeEixos(int eixos){
		return this.repositorioReboques.listarPorQuantidadeDeEixos(eixos);
	}
	
	public List<Reboque> listarPorCarga(Carga carga){
		return this.repositorioReboques.listarPorCarga(carga);
	}
}
