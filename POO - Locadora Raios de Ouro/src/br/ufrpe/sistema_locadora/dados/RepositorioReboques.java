package br.ufrpe.sistema_locadora.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.sistema_locadora.exceptions.ReboqueJaExisteException;
import br.ufrpe.sistema_locadora.exceptions.ReboqueNaoExisteException;
import br.ufrpe.sistema_locadora.negocio.beans.Carga;
import br.ufrpe.sistema_locadora.negocio.beans.Reboque;
import br.ufrpe.sistema_locadora.negocio.beans.StatusEnum;

public class RepositorioReboques implements IRepositorioReboques {
	private List<Reboque> reboques;
	private static RepositorioReboques instance;
	
	private RepositorioReboques() {
		this.reboques = new ArrayList<>();
	}

	@Override
	public void cadastrar(Reboque r) throws ReboqueJaExisteException {
		this.reboques.add(r);
		
	}

	@Override
	public void atualizar(Reboque r) {
		int indexReboque = this.reboques.indexOf(this.consultar(r.getPlaca(), r.getSerie()));
		this.reboques.set(indexReboque, r);
	}

	@Override
	public void remover(Reboque r) throws ReboqueNaoExisteException {
		this.reboques.remove(this.reboques.indexOf(r));
	}

	@Override
	public Reboque consultar(String placa, long numSerie) {
		Reboque aux = null;
		for(Reboque r: this.reboques)
			if(r.getPlaca().equals(placa) && r.getSerie() == numSerie)
				aux = r;
		return aux;
	}

	@Override
	public boolean existe(String placa) {
		boolean answ = false;
		for(Reboque r: this.reboques)
			if(r.getPlaca().equals(placa))
				answ = true;
		return answ;
	}

	@Override
	public List<Reboque> listarTodos() {
		return this.reboques;
	}

	@Override
	public List<Reboque> listarPorCarga(Carga carga) {
		List<Reboque> aux = new ArrayList<>();
		for(Reboque r: this.reboques)
			if(r.getTipoCarga().equals(carga))
				aux.add(r);
		return aux;
	}

	@Override
	public List<Reboque> listarPorStatus(StatusEnum status) {
		List<Reboque> aux = new ArrayList<>();
		for(Reboque r: this.reboques)
			if(r.getStatus().equals(status))
				aux.add(r);
		return aux;
	}

	@Override
	public List<Reboque> listarPorQuantidadeDeEixos(int eixos) {
		List<Reboque> aux = new ArrayList<>();
		for(Reboque r: this.reboques)
			if(r.getEixos() == eixos)
				aux.add(r);
		return aux;
	}

}
