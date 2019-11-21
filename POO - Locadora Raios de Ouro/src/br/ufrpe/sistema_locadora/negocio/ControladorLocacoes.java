package br.ufrpe.sistema_locadora.negocio;

import java.time.LocalDateTime;
import java.util.List;

import br.ufrpe.sistema_locadora.dados.IRepositorioLocacoes;
import br.ufrpe.sistema_locadora.exceptions.LocacaoNaoExisteException;
import br.ufrpe.sistema_locadora.exceptions.ReboqueIndisponivelException;
import br.ufrpe.sistema_locadora.negocio.beans.Locacao;
import br.ufrpe.sistema_locadora.negocio.beans.StatusEnum;

public class ControladorLocacoes {
private IRepositorioLocacoes repositorioLocacoes;
	
	public ControladorLocacoes(IRepositorioLocacoes instanciaRepositorio) {
		this.repositorioLocacoes = instanciaRepositorio;
	}
	
	public void cadastrar(Locacao l) throws ReboqueIndisponivelException{
		if(l == null) {
			throw new IllegalArgumentException("Parâmetro Inválido");
		} else {
			if (!this.repositorioLocacoes.existe(l.getCliente().getNome(), l.getDataHora())) {
				if(l.getReboque().getStatus() == StatusEnum.DISPONIVEL) {
					l.getReboque().setStatus(StatusEnum.LOCADO);
					this.repositorioLocacoes.cadastrar(l);
				}else {
					throw new ReboqueIndisponivelException(l.getReboque().getSerie());
				}
            } else {
                this.repositorioLocacoes.atualizar(l);
            }
		}
	}
	
	public void descadastrar(String nomeCliente, LocalDateTime dataHora) throws LocacaoNaoExisteException{
		Locacao l = this.repositorioLocacoes.consultar(nomeCliente, dataHora);
		if(l != null) {
			this.repositorioLocacoes.remover(l);
		}else {
			throw new LocacaoNaoExisteException(nomeCliente, dataHora);
		}
	}
	
	public void atualizar(Locacao l) {
		this.repositorioLocacoes.atualizar(l);
	}
	
	public Locacao procurar(String nomeCliente, LocalDateTime dataHora) {
		return this.repositorioLocacoes.consultar(nomeCliente, dataHora);
	}
	
	public boolean existe(Locacao l) {
		return this.repositorioLocacoes.existe(l.getCliente().getNome(), l.getDataHora());
	}
	
	public List<Locacao> listar(){
		return this.repositorioLocacoes.listarTodas();
	}
	
	public List<Locacao> listarPorCliente(String nomeCliente){
		return this.repositorioLocacoes.listarPorCliente(nomeCliente);
	}
	
	public List<Locacao> listarPorReboque(long numSerieReboque){
		return this.repositorioLocacoes.listarPorReboque(numSerieReboque);
	}
}
