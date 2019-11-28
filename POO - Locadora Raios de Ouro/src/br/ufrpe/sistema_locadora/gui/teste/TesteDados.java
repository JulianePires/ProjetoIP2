package br.ufrpe.sistema_locadora.gui.teste;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.ufrpe.sistema_locadora.exceptions.ClienteJaExisteException;
import br.ufrpe.sistema_locadora.exceptions.ReboqueIndisponivelException;
import br.ufrpe.sistema_locadora.exceptions.ReboqueJaExisteException;
import br.ufrpe.sistema_locadora.exceptions.UsuarioJaExisteException;
import br.ufrpe.sistema_locadora.negocio.FachadaLocadora;
import br.ufrpe.sistema_locadora.negocio.beans.Carga;
import br.ufrpe.sistema_locadora.negocio.beans.Cargo;
import br.ufrpe.sistema_locadora.negocio.beans.Cliente;
import br.ufrpe.sistema_locadora.negocio.beans.Locacao;
import br.ufrpe.sistema_locadora.negocio.beans.Manutencao;
import br.ufrpe.sistema_locadora.negocio.beans.Reboque;
import br.ufrpe.sistema_locadora.negocio.beans.Reserva;
import br.ufrpe.sistema_locadora.negocio.beans.StatusEnum;
import br.ufrpe.sistema_locadora.negocio.beans.Usuario;

public class TesteDados {

	public static void main(String[] args) {
		
		FachadaLocadora fachada = FachadaLocadora.getInstance();
		
		//Cadastro Usuarios
		try {
			fachada.cadastrar(new Usuario("Paulo", "068.356.985-65", LocalDate.of(1991, 3, 25), "Rua das Palmeiras, 50", "Barro", "Recife", "PE", "50900-120", "paulo@raiosdeouro.com", "paulo.user", "12345", LocalDateTime.now(), true, Cargo.FUNCIONARIO));
		} catch (UsuarioJaExisteException e2) {
			e2.printStackTrace();
		}
		Usuario u2 = new Usuario("Maria", "015.684.698-92", LocalDate.of(1982, 1, 6), "Rua Desconhecida, 233", "Várzea", "Recife", "PE", "52978-110", "maria@raiosdeouro.com", "maria.user", "12345", LocalDateTime.now(), true, Cargo.GERENTE);
		
		//Cadastro Clientes
		try {
			fachada.cadastrar(new Cliente("Joana", "052.698.654-21", LocalDate.of(1997, 2, 1), "Rua das Laranjeiras, 78", "Pina", "Recife", "PE", "51698-98", "joana@gmail.com", "36542215-98", "8199876631"));
		} catch (ClienteJaExisteException e1) {
			e1.printStackTrace();
		}
		Cliente c2 = new Cliente("Luis", "265.658.985-21", LocalDate.of(1990, 7, 9), "Rua das Laranjeiras, 78", "Pina", "Recife", "PE", "51698-98", "luis@gmail.com", "9865465-98", "81998776542");
		Cliente c3 = new Cliente("Francisco", "068.658.195-95", LocalDate.of(2013, 1, 1), "Rua da Amizade, 21", "Graças", "Recife", "PE", "52685-98", "francisco@hotmail.com", "", "8199865321");
		
		//Cadastro Reboques
		try {
			fachada.cadastrar(new Reboque(1, "PKG-1021", Carga.BAU, 2, StatusEnum.DISPONIVEL, 60.00));
		} catch (ReboqueJaExisteException e) {
			e.printStackTrace();
		}
		Reboque r2 = new Reboque(2, "KOY-2050", Carga.CARROS, 3, StatusEnum.DISPONIVEL, 120.00);
		Reboque r3 = new Reboque(3, "LGU-1098", Carga.PEQUENOPORTE, 1, StatusEnum.DISPONIVEL, 30.00);
		
		//Cadastro Manutencoes
		try {
			fachada.cadastrar(new Manutencao(fachada.pesquisar("PKG-1021", 1), "Troca de Pneus", "Pneus usados substituidos", "Oficina A", LocalDateTime.now(), 240.00));
		} catch (ReboqueIndisponivelException e) {
			e.printStackTrace();
		}
		
		//Cadastro Locacao
		try {
			fachada.cadastrar(new Locacao(r2, fachada.procurar("51698-98"), fachada.procurar("Paulo", "paulo.user"), LocalDateTime.now(), 4, 0));
		} catch (ReboqueIndisponivelException e) {
			e.printStackTrace();
		}
		
		//Cadastro Reserva
		try {
			fachada.cadastrar(new Reserva(r3, c3, u2, LocalDateTime.now(), 5));
		} catch (ReboqueIndisponivelException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		

	}

}
