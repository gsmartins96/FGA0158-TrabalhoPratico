package Classes;

import java.util.Scanner;

import java.text.SimpleDateFormat;  
import java.util.Date;  

public class main {

	Veiculo[] veiculos;
	Proprietario[] proprietarios;
	Estacionamento[] acessos;

	public static Proprietario cadastroProprietario(){

		Proprietario o_Proprietario = new Proprietario();
		return;
	}

	public static Veiculo cadastroVeiculo(){
		System.out.println("Marca:");
		String marca = sc.next();

		System.out.println("Modelo:");
		String modelo = sc.next();

		System.out.println("Placa:");
		String placa = sc.next();

		Veiculo o_Veiculo = new Veiculo(marca, modelo, placa);

		System.out.println("É veículo de mensalidade? S/N");
		String resposta = sc.next();
		if(resposta == "N"){
			System.out.println(o_Veiculo.Trace());
			return o_Veiculo;	
		} else {
			Proprietario p = cadastroProprietario();
			o_Veiculo.setProprietario(p);
			proprietarios.push( p );
		}

		
	}

	public static void novoAcesso(){

		// escolher veículo

		System.out.println("Dia de Acesso:");
		String DataAcesso = sc.next();
		
		System.out.println("Hora de Entrada:");
		String HoraEntrada = sc.next();
		
		System.out.println("Hora de Saída:");
		String HoraSaida = sc.next();
		
		Estacionamento o_Estacionamento = new Estacionamento(DataAcesso, HoraEntrada, HoraSaida);
		
		System.out.println(o_Estacionamento.Trace());
	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Bem-vindo ao programa de estacionamento, escolha uma opção:");
		System.out.println("1 - Cadastrar novo veículo");
		System.out.println("2 - Cadastrar novo acesso a veículo existente");
		String opcaoEscolhida = sc.next();

		switch (opcaoEscolhida){
			case 1:
				veiculos.push( cadastroVeiculo() );
				break;
			case 2:
				novoAcesso();
				break;
			default:
				return;

		}

		
		
	}
}