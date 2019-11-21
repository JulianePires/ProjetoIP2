package br.ufrpe.sistema_locadora.negocio;

import java.time.LocalDateTime;
import java.util.List;

import br.ufrpe.sistema_locadora.dados.IRepositorioManutencoes;
import br.ufrpe.sistema_locadora.exceptions.ReboqueIndisponivelException;
import br.ufrpe.sistema_locadora.negocio.beans.Manutencao;
import br.ufrpe.sistema_locadora.negocio.beans.Reboque;
import br.ufrpe.sistema_locadora.negocio.beans.StatusEnum;

public class ControladorManutencoes {
	private IRepositorioManutencoes repositorioManutencoes;

	public ControladorManutencoes(IRepositorioManutencoes instanciaRepositorio) {
		this.repositorioManutencoes = instanciaRepositorio;
	}

	public void cadastrar(Manutencao m) throws ReboqueIndisponivelException {
		if(m == null) {
			throw new IllegalArgumentException("Parâmetro Inválido");
		} else {
			if(!this.repositorioManutencoes.existe(m.getReboque().getSerie())) {
				if(m.getReboque().getStatus() == StatusEnum.DISPONIVEL) {
					m.getReboque().setStatus(StatusEnum.MANUTENCAO);
					this.repositorioManutencoes.cadastrar(m);
				}else {
					throw new ReboqueIndisponivelException(m.getReboque().getSerie());
				}
			} else {
				this.repositorioManutencoes.atualizar(m);
			}
		}
	}

	public void descadastrar(Manutencao m) {
		if(m != null) {
			this.repositorioManutencoes.remover(m);
		}
	}
	
	public void atualizar(Manutencao m) {
		this.repositorioManutencoes.atualizar(m);
	}
	
	public boolean existe(long numSerieReboque) {
		return this.existe(numSerieReboque);
	}
	
	public Manutencao pesquisar(long numSerieReboque, LocalDateTime dataHora, String servico) {
		return this.repositorioManutencoes.consultar(numSerieReboque, dataHora, servico);
	}
	
	public List<Manutencao> listar(){
		return this.repositorioManutencoes.listarTodos();
	}
	
	public List<Manutencao> listarPorServico(String servico){
		return this.repositorioManutencoes.listarPorServico(servico);
	}
	
	public List<Manutencao> listarPorDataHora(LocalDateTime dataHora){
		return this.repositorioManutencoes.listarPorDataHora(dataHora);
	}
	
	public List<Manutencao> listarPorReboque(Reboque r){
		return this.repositorioManutencoes.listarPorReboque(r);
	}
	
}
