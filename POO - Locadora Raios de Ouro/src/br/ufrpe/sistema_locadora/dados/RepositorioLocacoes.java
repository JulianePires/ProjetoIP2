package br.ufrpe.sistema_locadora.dados;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.sistema_locadora.exceptions.LocacaoNaoExisteException;
import br.ufrpe.sistema_locadora.exceptions.ReboqueIndisponivelException;
import br.ufrpe.sistema_locadora.negocio.beans.Locacao;

public class RepositorioLocacoes implements IRepositorioLocacoes {
	private List<Locacao> locacoes;
	private static RepositorioLocacoes instance;
	
	private RepositorioLocacoes() {
		super();
		this.locacoes = new ArrayList<>();
	}

	@Override
	public void cadastrar(Locacao l) throws ReboqueIndisponivelException {
		this.locacoes.add(l);
	}

	@Override
	public void atualizar(Locacao l) {
		int indexLocacao = this.locacoes.indexOf(this.consultar(l.getCliente().getNome(), l.getDataHora()));
		this.locacoes.set(indexLocacao, l);
	}

	@Override
	public void remover(Locacao l) throws LocacaoNaoExisteException {
		this.locacoes.remove(this.locacoes.indexOf(l));
		
	}

	@Override
	public Locacao consultar(String nomeCliente, LocalDateTime dataHora) {
		Locacao aux = null;
		for(Locacao l: this.locacoes)
			if(l.getCliente().getNome().equals(nomeCliente) && l.getDataHora().equals(dataHora))
				aux = l;
		return aux;
	}

	@Override
	public boolean existe(String nomeCliente, LocalDateTime dataHora) {
		boolean answ = false;
		for(Locacao l: this.locacoes)
			if(l.getCliente().getNome().equals(nomeCliente) && l.getDataHora().equals(dataHora))
				answ = true;
		return answ;
	}

	@Override
	public List<Locacao> listarTodas() {
		return this.locacoes;
	}

	@Override
	public List<Locacao> listarPorData(LocalDateTime dataHora) {
		List<Locacao> aux = new ArrayList<>();
		for(Locacao l: this.locacoes)
			if(l.getDataHora().equals(dataHora)) {
				aux.add(l);
			}
		return aux;
	}

	@Override
	public List<Locacao> listarPorCliente(String nomeCliente) {
		List<Locacao> aux = new ArrayList<>();
		for(Locacao l: this.locacoes)
			if(l.getCliente().getNome().equals(nomeCliente))
				aux.add(l);
		return aux;
	}

	@Override
	public List<Locacao> listarPorReboque(long numSerieReboque) {
		List<Locacao> aux = new ArrayList<>();
		for(Locacao l: this.locacoes)
			if(l.getReboque().getSerie() == numSerieReboque)
				aux.add(l);
		return aux;
	}

}
