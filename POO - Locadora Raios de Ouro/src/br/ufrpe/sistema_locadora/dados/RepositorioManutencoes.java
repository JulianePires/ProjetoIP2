package br.ufrpe.sistema_locadora.dados;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import br.ufrpe.sistema_locadora.exceptions.ReboqueIndisponivelException;
import br.ufrpe.sistema_locadora.negocio.beans.Manutencao;
import br.ufrpe.sistema_locadora.negocio.beans.Reboque;

public class RepositorioManutencoes implements IRepositorioManutencoes {
	private List<Manutencao> manutencoes;
	private static RepositorioManutencoes instance;
	
	private RepositorioManutencoes() {
		super();
		this.manutencoes = new ArrayList<>();
	}
	
	public IRepositorioManutencoes getInstance() {
		 if (instance == null) {
	            instance = new RepositorioManutencoes();
	        }
	        return instance;
	}

	@Override
	public void cadastrar(Manutencao m) throws ReboqueIndisponivelException {
		this.manutencoes.add(m);
	}

	@Override
	public void atualizar(Manutencao m) {
		int indexManutencao = 
				this.manutencoes.indexOf(this.consultar(m.getReboque().getSerie(), m.getDataHora(), m.getTipoServico()));
		this.manutencoes.set(indexManutencao, m);
	}

	@Override
	public void remover(Manutencao m) {
		this.manutencoes.remove(this.manutencoes.indexOf(m));
	}

	@Override
	public Manutencao consultar(long numSerieReboque, LocalDateTime dataHora, String servico) {
		Manutencao aux = null;
		for(Manutencao m: this.manutencoes)
			if(m.getReboque().getSerie() == numSerieReboque && m.getDataHora().equals(dataHora) && m.getTipoServico().equals(servico))
				aux = m;
		return aux;
	}

	@Override
	public boolean existe(long numSerieReboque) {
		boolean answ = false;
		for(Manutencao m: this.manutencoes)
			if(m.getReboque().getSerie() == numSerieReboque)
				answ = true;
		return answ;
	}

	@Override
	public List<Manutencao> listarTodos() {
		return this.manutencoes;
	}

	@Override
	public List<Manutencao> listarPorServico(String servico) {
		List<Manutencao> aux = new ArrayList<>();
		for(Manutencao m: this.manutencoes)
			if(m.getTipoServico().equals(servico))
				aux.add(m);
		return aux;
	}

	@Override
	public List<Manutencao> listarPorDataHora(LocalDateTime dataHora) {
		List<Manutencao> aux = new ArrayList<>();
		for(Manutencao m: this.manutencoes)
			if(m.getDataHora().equals(dataHora))
				aux.add(m);
		return aux;
	}

	@Override
	public List<Manutencao> listarPorReboque(Reboque r) {
		List<Manutencao> aux = new ArrayList<>();
		for(Manutencao m: this.manutencoes)
			if(m.getReboque().equals(r))
				aux.add(m);
		return aux;
	}
	
}
