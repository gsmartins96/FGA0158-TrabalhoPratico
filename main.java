package oo_estacionamento;

import java.util.Scanner;

import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.ArrayList;

public class main {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Veiculo> veiculos = new ArrayList();
	static ArrayList<Proprietario> proprietarios = new ArrayList();
	static ArrayList<Estacionamento> acessos = new ArrayList();

	public static Proprietario cadastroProprietario(Veiculo v){
		String nome, endereco, celular, telefone, cnh;
		
		try{
			System.out.println("Nome:");
			nome = sc.next();

			System.out.println("Endereco:");
			endereco = sc.next();

			System.out.println("Celular:");
			celular = sc.next();
			
			System.out.println("Telefone");
			telefone = sc.next();
			
			System.out.println("CNH");
			cnh = sc.next();

			if(nome == "")
				throw new DadosPessoaisIncompletosException("Campo vazio: Nome");
			if(endereco == "")
				throw new DadosPessoaisIncompletosException("Campo vazio: Endereco");
			if(celular == "")
			 	throw new DadosPessoaisIncompletosException("Campo vazio: Celular");
			if(telefone == "")
				throw new DadosPessoaisIncompletosException("Campo vazio: Telefone");
			if(cnh == "")
				throw new DadosPessoaisIncompletosException("Campo vazio: CNH")
		} catch (DadosPessoaisIncompletosException e) {
			System.out.println("Por favor, preencha todos os campos. " + e.getMessage());
			return null;
		}
		
		Proprietario o_Proprietario = new Proprietario(nome, endereco, celular, telefone, cnh);
		o_Proprietario.addVeiculo(v);
		return o_Proprietario;
	}
	
	public static Veiculo cadastroVeiculo(){
		String marca, modelo, placa;

		try{
			System.out.println("Marca:");
			marca = sc.next();

			System.out.println("Modelo:");
			modelo = sc.next();

			System.out.println("Placa:");
			placa = sc.next();

			if(marca == "")
				throw new DadosVeiculosIncompletosException("Campo vazio: marca");
			if(modelo == "")
				throw new DadosVeiculosIncompletosException("Campo vazio: modelo");
			if(placa == "")
			 	throw new DadosVeiculosIncompletosException("Campo vazio: placa");
		} catch (DadosVeiculosIncompletosException e) {
			System.out.println("Por favor, preencha todos os campos. " + e.getMessage());
			return null;
		}


		Veiculo o_Veiculo = new Veiculo(marca, modelo, placa);

		System.out.println("O veiculo de mensalidade? S/N");
		String resposta = sc.next().toUpperCase();
		
		switch (resposta) {
		case "N": 
			System.out.println(o_Veiculo.Trace());
			return o_Veiculo;
		case "S":
			Proprietario p = cadastroProprietario(o_Veiculo);
			o_Veiculo.setProprietario(p);
			proprietarios.add( p );
			break;
		default:
			System.out.println("Escreva S ou N!");
		}
		
		return o_Veiculo;

		
	}

	public static void novoAcesso(){

		// escolher veiculo

		String DataAcesso = null, HoraEntrada = null, HoraSaida = null;
		
		
		try{
			System.out.println("Data de Acesso:");
			DataAcesso = sc.next();

			System.out.println("Hora de Entrada(hh:mm):");
			HoraEntrada = sc.next();

			System.out.println("Hora de Saida(hh:mm):");
			HoraSaida = sc.next();

			if(DataAcesso == "")
				throw new DadosAcessoIncompletosException("Campo vazio: Data de Acesso");
			if(HoraEntrada == "")
				throw new DadosAcessoIncompletosException("Campo vazio: Hora de entrada");
			if(HoraSaida == "")
			 	throw new DadosAcessoIncompletosException("Campo vazio: Hora de saida");

			// Dividindo horas e minutos em inteiros
			String HEsplit[] = HoraEntrada.split(":");
			int horaEntrada = Integer.parseInt(HEsplit[0]);
			int minutoEntrada = Integer.parseInt(HEsplit[1]);
			String HSsplit[] = HoraSaida.split(":");
			int horaSaida = Integer.parseInt(HSsplit[0]);
			int minutoSaida = Integer.parseInt(HSsplit[1]);

			if((horaEntrada >= 20) && (horaEntrada <= 6))
				throw new EstacionamentoFechadoException("Horário de entrada");
			if((horaSaida >= 20) && (horaSaida <= 6))
				throw new EstacionamentoFechadoException("Horário de saída");
			if(horaSaida*60+minutoSaida - horaEntrada*60+minutoEntrada <= 0)
				throw new PeriodoInvalidoException("Possível pernoite");
			
		} catch (DadosAcessoIncompletosException e) {
			System.out.println("Por favor, preencha todos os campos. " + e.getMessage());
			return;
		} catch (EstacionamentoFechadoException e) {
			System.out.println("Horário inválido, o seguinte horário foi inserido enquanto o estacionamento estava fechado: " + e.getMessage());
			return;
		} catch (PeriodoInvalidoException e) {
			System.out.println("Horário registrado indica pernoite? S/N");
			String resposta = sc.next().toUpperCase();
			switch (resposta) {
				case "N": 
					System.out.println("Período de estadia inválido");
					return;
				case "S":
					break;
			}
		}
		
		Estacionamento o_Estacionamento = new Estacionamento(DataAcesso, HoraEntrada, HoraSaida);
		
		System.out.println(o_Estacionamento.Trace());
	}

	public static void main(String[] args) {
		String opcaoEscolhida;
		
		do{
			System.out.println("Bem-vindo ao programa de estacionamento, escolha uma opcao:");
			System.out.println("1 - Cadastrar novo veiculo");
			System.out.println("2 - Cadastrar novo acesso a veiculo existente");
			System.out.println("0 - Sair");
			opcaoEscolhida = sc.next();
			
			switch (opcaoEscolhida){
				case "1":
					veiculos.add( cadastroVeiculo() );
					break;
				case "2":
					novoAcesso();
					break;
			}
		} while (opcaoEscolhida != "0");		
	}
}
