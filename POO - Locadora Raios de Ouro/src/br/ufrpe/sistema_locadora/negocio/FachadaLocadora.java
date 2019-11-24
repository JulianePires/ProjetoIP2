package br.ufrpe.sistema_locadora.negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.ufrpe.sistema_locadora.dados.RepositorioClientes;
import br.ufrpe.sistema_locadora.dados.RepositorioLocacoes;
import br.ufrpe.sistema_locadora.dados.RepositorioManutencoes;
import br.ufrpe.sistema_locadora.dados.RepositorioReboques;
import br.ufrpe.sistema_locadora.dados.RepositorioReservas;
import br.ufrpe.sistema_locadora.dados.RepositorioUsuarios;
import br.ufrpe.sistema_locadora.exceptions.ClienteJaExisteException;
import br.ufrpe.sistema_locadora.exceptions.ClienteNaoExisteException;
import br.ufrpe.sistema_locadora.exceptions.LocacaoNaoExisteException;
import br.ufrpe.sistema_locadora.exceptions.ReboqueIndisponivelException;
import br.ufrpe.sistema_locadora.exceptions.ReboqueJaExisteException;
import br.ufrpe.sistema_locadora.exceptions.ReboqueNaoExisteException;
import br.ufrpe.sistema_locadora.exceptions.ReservaNaoExisteException;
import br.ufrpe.sistema_locadora.exceptions.UsuarioJaExisteException;
import br.ufrpe.sistema_locadora.exceptions.UsuarioNaoExisteException;
import br.ufrpe.sistema_locadora.negocio.beans.Carga;
import br.ufrpe.sistema_locadora.negocio.beans.Cargo;
import br.ufrpe.sistema_locadora.negocio.beans.Cliente;
import br.ufrpe.sistema_locadora.negocio.beans.Locacao;
import br.ufrpe.sistema_locadora.negocio.beans.Manutencao;
import br.ufrpe.sistema_locadora.negocio.beans.Reboque;
import br.ufrpe.sistema_locadora.negocio.beans.Reserva;
import br.ufrpe.sistema_locadora.negocio.beans.StatusEnum;
import br.ufrpe.sistema_locadora.negocio.beans.Usuario;

public class FachadaLocadora {
	private ControladorClientes controladorClientes;
	private ControladorLocacoes controladorLocacoes;
	private ControladorManutencoes controladorManutencoes;
	private ControladorReboques controladorReboques;
	private ControladorReservas controladorReservas;
	private ControladorUsuarios controladorUsuarios;
	private static FachadaLocadora instance;
	
	private FachadaLocadora() {
		this.controladorClientes = new ControladorClientes(RepositorioClientes.getInstance());
		this.controladorLocacoes = new ControladorLocacoes(RepositorioLocacoes.getInstance());
		this.controladorManutencoes = new ControladorManutencoes(RepositorioManutencoes.getInstance());
		this.controladorReboques = new ControladorReboques(RepositorioReboques.getInstance());
		this.controladorReservas = new ControladorReservas(RepositorioReservas.getInstance());
		this.controladorUsuarios = new ControladorUsuarios(RepositorioUsuarios.getInstance());
	}
	
	//Padrão singleton implantado
	public static FachadaLocadora getInstance() {
		if(instance == null)
			instance = new FachadaLocadora();
		return instance;
	}

	/**
	 * @param c
	 * @throws ClienteJaExisteException
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorClientes#cadastrar(br.ufrpe.sistema_locadora.negocio.beans.Cliente)
	 */
	public void cadastrar(Cliente c) throws ClienteJaExisteException {
		controladorClientes.cadastrar(c);
	}

	/**
	 * @param nome
	 * @throws ClienteNaoExisteException
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorClientes#descadastrar(java.lang.String)
	 */
	public void descadastrar(String nome) throws ClienteNaoExisteException {
		controladorClientes.descadastrar(nome);
	}

	/**
	 * @param nome
	 * @throws ClienteNaoExisteException
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorClientes#atualizar(java.lang.String)
	 */
	public void atualizar(String nome) throws ClienteNaoExisteException {
		controladorClientes.atualizar(nome);
	}

	/**
	 * @param cnh
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorClientes#procurar(java.lang.String)
	 */
	public Cliente procurar(String cnh) {
		return controladorClientes.procurar(cnh);
	}

	/**
	 * @param nome
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorClientes#existe(java.lang.String)
	 */
	public boolean existe(String nome) {
		return controladorClientes.existe(nome);
	}

	/**
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return controladorClientes.hashCode();
	}

	/**
	 * @param c
	 * @throws ClienteNaoExisteException
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorClientes#remover(br.ufrpe.sistema_locadora.negocio.beans.Cliente)
	 */
	public void remover(Cliente c) throws ClienteNaoExisteException {
		controladorClientes.remover(c);
	}

	/**
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorClientes#listarClientes()
	 */
	public List<Cliente> listarClientes() {
		return controladorClientes.listarClientes();
	}

	/**
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		return controladorClientes.equals(obj);
	}

	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return controladorClientes.toString();
	}

	/**
	 * @param l
	 * @throws ReboqueIndisponivelException
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorLocacoes#cadastrar(br.ufrpe.sistema_locadora.negocio.beans.Locacao)
	 */
	public void cadastrar(Locacao l) throws ReboqueIndisponivelException {
		controladorLocacoes.cadastrar(l);
	}

	/**
	 * @param nomeCliente
	 * @param dataHora
	 * @throws LocacaoNaoExisteException
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorLocacoes#descadastrar(java.lang.String, java.time.LocalDateTime)
	 */
	public void descadastrar(String nomeCliente, LocalDateTime dataHora) throws LocacaoNaoExisteException {
		controladorLocacoes.descadastrar(nomeCliente, dataHora);
	}

	/**
	 * @param l
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorLocacoes#atualizar(br.ufrpe.sistema_locadora.negocio.beans.Locacao)
	 */
	public void atualizar(Locacao l) {
		controladorLocacoes.atualizar(l);
	}

	/**
	 * @param nomeCliente
	 * @param dataHora
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorLocacoes#procurar(java.lang.String, java.time.LocalDateTime)
	 */
	public Locacao procurar(String nomeCliente, LocalDateTime dataHora) {
		return controladorLocacoes.procurar(nomeCliente, dataHora);
	}

	/**
	 * @param l
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorLocacoes#existe(br.ufrpe.sistema_locadora.negocio.beans.Locacao)
	 */
	public boolean existe(Locacao l) {
		return controladorLocacoes.existe(l);
	}

	/**
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorLocacoes#listar()
	 */
	public List<Locacao> listar() {
		return controladorLocacoes.listar();
	}

	/**
	 * @param nomeCliente
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorLocacoes#listarPorCliente(java.lang.String)
	 */
	public List<Locacao> listarPorCliente(String nomeCliente) {
		return controladorLocacoes.listarPorCliente(nomeCliente);
	}

	/**
	 * @param numSerieReboque
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorLocacoes#listarPorReboque(long)
	 */
	public List<Locacao> listarPorReboque(long numSerieReboque) {
		return controladorLocacoes.listarPorReboque(numSerieReboque);
	}

	/**
	 * @param m
	 * @throws ReboqueIndisponivelException
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorManutencoes#cadastrar(br.ufrpe.sistema_locadora.negocio.beans.Manutencao)
	 */
	public void cadastrar(Manutencao m) throws ReboqueIndisponivelException {
		controladorManutencoes.cadastrar(m);
	}

	/**
	 * @param m
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorManutencoes#descadastrar(br.ufrpe.sistema_locadora.negocio.beans.Manutencao)
	 */
	public void descadastrar(Manutencao m) {
		controladorManutencoes.descadastrar(m);
	}

	/**
	 * @param m
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorManutencoes#atualizar(br.ufrpe.sistema_locadora.negocio.beans.Manutencao)
	 */
	public void atualizar(Manutencao m) {
		controladorManutencoes.atualizar(m);
	}

	/**
	 * @param numSerieReboque
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorManutencoes#existe(long)
	 */
	public boolean existe(long numSerieReboque) {
		return controladorManutencoes.existe(numSerieReboque);
	}

	/**
	 * @param numSerieReboque
	 * @param dataHora
	 * @param servico
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorManutencoes#pesquisar(long, java.time.LocalDateTime, java.lang.String)
	 */
	public Manutencao pesquisar(long numSerieReboque, LocalDateTime dataHora, String servico) {
		return controladorManutencoes.pesquisar(numSerieReboque, dataHora, servico);
	}

	/**
	 * @param servico
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorManutencoes#listarPorServico(java.lang.String)
	 */
	public List<Manutencao> listarPorServico(String servico) {
		return controladorManutencoes.listarPorServico(servico);
	}

	/**
	 * @param dataHora
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorManutencoes#listarPorDataHora(java.time.LocalDateTime)
	 */
	public List<Manutencao> listarPorDataHora(LocalDateTime dataHora) {
		return controladorManutencoes.listarPorDataHora(dataHora);
	}

	/**
	 * @param r
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorManutencoes#listarPorReboque(br.ufrpe.sistema_locadora.negocio.beans.Reboque)
	 */
	public List<Manutencao> listarPorReboque(Reboque r) {
		return controladorManutencoes.listarPorReboque(r);
	}

	/**
	 * @param r
	 * @throws ReboqueJaExisteException
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorReboques#cadastrar(br.ufrpe.sistema_locadora.negocio.beans.Reboque)
	 */
	public void cadastrar(Reboque r) throws ReboqueJaExisteException {
		controladorReboques.cadastrar(r);
	}

	/**
	 * @param placa
	 * @param numSerie
	 * @throws ReboqueNaoExisteException
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorReboques#descadastrar(java.lang.String, long)
	 */
	public void descadastrar(String placa, long numSerie) throws ReboqueNaoExisteException {
		controladorReboques.descadastrar(placa, numSerie);
	}

	/**
	 * @param placa
	 * @param numSerie
	 * @throws ReboqueNaoExisteException
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorReboques#atualizar(java.lang.String, long)
	 */
	public void atualizar(String placa, long numSerie) throws ReboqueNaoExisteException {
		controladorReboques.atualizar(placa, numSerie);
	}

	/**
	 * @param placa
	 * @param numSerie
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorReboques#pesquisar(java.lang.String, long)
	 */
	public Reboque pesquisar(String placa, long numSerie) {
		return controladorReboques.pesquisar(placa, numSerie);
	}

	/**
	 * @param status
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorReboques#listarPorStatus(br.ufrpe.sistema_locadora.negocio.beans.StatusEnum)
	 */
	public List<Reboque> listarPorStatus(StatusEnum status) {
		return controladorReboques.listarPorStatus(status);
	}

	/**
	 * @param eixos
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorReboques#listarPorQuantidadeDeEixos(int)
	 */
	public List<Reboque> listarPorQuantidadeDeEixos(int eixos) {
		return controladorReboques.listarPorQuantidadeDeEixos(eixos);
	}

	/**
	 * @param carga
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorReboques#listarPorCarga(br.ufrpe.sistema_locadora.negocio.beans.Carga)
	 */
	public List<Reboque> listarPorCarga(Carga carga) {
		return controladorReboques.listarPorCarga(carga);
	}

	/**
	 * @param r
	 * @throws ReboqueIndisponivelException
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorReservas#cadastrar(br.ufrpe.sistema_locadora.negocio.beans.Reserva)
	 */
	public void cadastrar(Reserva r) throws ReboqueIndisponivelException {
		controladorReservas.cadastrar(r);
	}

	/**
	 * @param r
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorReservas#atualizar(br.ufrpe.sistema_locadora.negocio.beans.Reserva)
	 */
	public void atualizar(Reserva r) {
		controladorReservas.atualizar(r);
	}

	/**
	 * @param r
	 * @throws ReservaNaoExisteException
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorReservas#descadastrar(br.ufrpe.sistema_locadora.negocio.beans.Reserva)
	 */
	public void descadastrar(Reserva r) throws ReservaNaoExisteException {
		controladorReservas.descadastrar(r);
	}

	/**
	 * @param nomeCliente
	 * @param dataHora
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorReservas#procurar(java.lang.String, java.time.LocalDateTime)
	 */
	public Reserva procurarReserva(String nomeCliente, LocalDateTime dataHora) {
		return controladorReservas.procurar(nomeCliente, dataHora);
	}

	/**
	 * @param nomeCliente
	 * @param dataHora
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorReservas#existe(java.lang.String, java.time.LocalDateTime)
	 */
	public boolean existe(String nomeCliente, LocalDateTime dataHora) {
		return controladorReservas.existe(nomeCliente, dataHora);
	}

	/**
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorReservas#listarTodas()
	 */
	public List<Reserva> listarTodas() {
		return controladorReservas.listarTodas();
	}

	/**
	 * @param data
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorReservas#listarPorData(java.time.LocalDate)
	 */
	public List<Reserva> listarPorData(LocalDate data) {
		return controladorReservas.listarPorData(data);
	}

	/**
	 * @param u
	 * @throws UsuarioJaExisteException
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorUsuarios#cadastrar(br.ufrpe.sistema_locadora.negocio.beans.Usuario)
	 */
	public void cadastrar(Usuario u) throws UsuarioJaExisteException {
		controladorUsuarios.cadastrar(u);
	}

	/**
	 * @param u
	 * @throws UsuarioNaoExisteException
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorUsuarios#descadastrar(br.ufrpe.sistema_locadora.negocio.beans.Usuario)
	 */
	public void descadastrar(Usuario u) throws UsuarioNaoExisteException {
		controladorUsuarios.descadastrar(u);
	}

	/**
	 * @param u
	 * @throws UsuarioNaoExisteException
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorUsuarios#atualizar(br.ufrpe.sistema_locadora.negocio.beans.Usuario)
	 */
	public void atualizar(Usuario u) throws UsuarioNaoExisteException {
		controladorUsuarios.atualizar(u);
	}

	/**
	 * @param nome
	 * @param login
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorUsuarios#procurar(java.lang.String, java.lang.String)
	 */
	public Usuario procurar(String nome, String login) {
		return controladorUsuarios.procurar(nome, login);
	}

	/**
	 * @param u
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorUsuarios#existe(br.ufrpe.sistema_locadora.negocio.beans.Usuario)
	 */
	public boolean existe(Usuario u) {
		return controladorUsuarios.existe(u);
	}

	/**
	 * @param cargo
	 * @return
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorUsuarios#listarPorCargo(br.ufrpe.sistema_locadora.negocio.beans.Cargo)
	 */
	public List<Usuario> listarPorCargo(Cargo cargo) {
		return controladorUsuarios.listarPorCargo(cargo);
	}

	/**
	 * @param nome
	 * @param login
	 * @throws UsuarioNaoExisteException
	 * @see br.ufrpe.sistema_locadora.negocio.ControladorUsuarios#desligarFuncionario(java.lang.String, java.lang.String)
	 */
	public void desligarFuncionario(String nome, String login) throws UsuarioNaoExisteException {
		controladorUsuarios.desligarFuncionario(nome, login);
	}
	
	
	
}
