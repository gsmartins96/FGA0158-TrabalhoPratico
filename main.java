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
		String nome, endereco;
		int celular, telefone, cnh;
		
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
				throw new DadosPessoaisIncompletosException("Campo vazio: CNH");
		} catch (DadosPessoaisIncompletosException e) {
			System.out.println("Por favor, preencha todos os campos. " + e.getMessage());
			return null;
		}
		
		Proprietario o_Proprietario = new Proprietario(nome, endereco, celular, telefone, cnh);
		return o_Proprietario;
	}
	
	public static void cadastroVeiculo(){
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
			return;
		}

		Veiculo o_Veiculo = new Veiculo(marca, modelo, placa);

		System.out.println("É veiculo de mensalidade? S/N");
		String resposta = sc.next().toUpperCase();
		
		switch (resposta) {
		case "N": 
			break;
		case "S":
			Proprietario p = cadastroProprietario(o_Veiculo);
			o_Veiculo.setProprietario(p);
			break;
		default:
			System.out.println("Escreva S ou N!");
		}

		veiculos.add( o_Veiculo );
		
		return;
	}

	public static Veiculo procurarVeiculo(String placa){
		for(int i = 0; i<veiculos.size(); i++){
			Veiculo v = veiculos.get(i);
			if(v.getPlaca().equals(placa)) return v;
		}

		return null;
	}

	public static void novoAcesso(){

		// escolher veiculo
		System.out.println("Digite a placa do veículo:");
		String placa = sc.next();
		Veiculo v = procurarVeiculo(placa);
		if(v == null){
			System.out.println("Placa não encontrada");
			return;
		}

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
				throw new EstacionamentoFechadoException("HorÃ¡rio de entrada");
			if((horaSaida >= 20) && (horaSaida <= 6))
				throw new EstacionamentoFechadoException("HorÃ¡rio de saÃ­da");
			if(horaSaida*60+minutoSaida - horaEntrada*60+minutoEntrada <= 0)
				throw new PeriodoInvalidoException("PossÃ­vel pernoite");
			
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
					System.out.println("PerÃ­odo de estadia invÃ¡lido");
					return;
				case "S":
					break;
			}
		}
		
		Estacionamento o_Estacionamento = new Estacionamento(DataAcesso, HoraEntrada, HoraSaida, v);
		System.out.printf("Valor do Estacionamento: R$ %.2f \n", o_Estacionamento.getValorEstacionamento());
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
					cadastroVeiculo();
					break;
				case "2":
					novoAcesso();
					break;
			}
		} while (!opcaoEscolhida.equals("0"));

		System.out.printf("Faturamento da sessão: R$ %.2f", Estacionamento.getFaturamento());
	}
}
