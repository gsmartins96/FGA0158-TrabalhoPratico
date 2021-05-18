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
		System.out.println("Nome:");
		String nome = sc.next();

		System.out.println("Endereco:");
		String endereco = sc.next();

		System.out.println("Celular:");
		String celular = sc.next();
		
		System.out.println("Telefone:");
		String telefone = sc.next();
		
		System.out.println("CNH:");
		String cnh = sc.next();
		
		Proprietario o_Proprietario = new Proprietario(nome, endereco, celular, telefone, cnh);
		o_Proprietario.addVeiculo(v);
		return o_Proprietario;
	}

	public static Veiculo cadastroVeiculo(){

		try{
			System.out.println("Marca:");
			String marca = sc.next();

			System.out.println("Modelo:");
			String modelo = sc.next();

			System.out.println("Placa:");
			String placa = sc.next();

			if(marca == "")
				throw new DadosVeiculosIncompletosException("Campo vazio: marca");
			if(modelo == "")
				throw new DadosVeiculosIncompletosException("Campo vazio: modelo");
			if(placa == "")
			 	throw new DadosVeiculosIncompletosException("Campo vazio: placa");
		} catch (DadosVeiculosIncompletosException e) {
			System.out.println("Por favor, preencha todos os campos. " + e.getMessage());
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
		
		// Guardar hora e minuto de entrada
		System.out.println("Hora de Entrada(hh:mm):");
		String HEntrada = sc.next();
		
		String HEsplit[] = HEntrada.split(":");
		int HoraEntrada = Integer.parseInt(HEsplit[0]);
		int MinutoEntrada = Integer.parseInt(HEsplit[1]);
		// Guardar hora e minuto de saida
		System.out.println("Hora de Saida(hh:mm):");
		String HSaida = sc.next();
		
		String HSsplit[] = HSaida.split(":");
		int HoraSaida = Integer.parseInt(HSsplit[0]);
		int MinutoSaida = Integer.parseInt(HSsplit[1]);
		
		// Converte para apenas minutos
		int Tin = HoraEntrada*60+MinutoEntrada;
		int Tout = HoraSaida*60+MinutoSaida;
		
		// Calcula o tempo de estadia (em minutos)
		if (Tout <= Tin) {
			Tout += 1440;
		}
		int Estadia = Tin - Tout; // AQUI ESTÁ O TEMPO DE ESTADIA EM MINUTOS
		
		Estacionamento o_Estacionamento = new Estacionamento(DataAcesso, HoraEntrada, HoraSaida);
		
		System.out.println(o_Estacionamento.Trace());
	}



	public static void main(String[] args) {
		System.out.println("Bem-vindo ao programa de estacionamento, escolha uma opcao:");
		System.out.println("1 - Cadastrar novo veiculo");
		System.out.println("2 - Cadastrar novo acesso a veiculo existente");
		String opcaoEscolhida = sc.next();

		switch (opcaoEscolhida){
			case "1":
				veiculos.add( cadastroVeiculo() );
				break;
			case "2":
				novoAcesso();
				break;
			default:
				return;

		}

		
		
	}
}
