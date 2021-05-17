package oo_estacionamento;

import java.util.Scanner;

import java.text.SimpleDateFormat;  
import java.util.Date;  

public class main {
	static Scanner sc = new Scanner(System.in);
	Veiculo[] veiculos;
	static Proprietario[] proprietarios;
	Estacionamento[] acessos;

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
		System.out.println("Marca:");
		String marca = sc.next();

		System.out.println("Modelo:");
		String modelo = sc.next();

		System.out.println("Placa:");
		String placa = sc.next();

		Veiculo o_Veiculo = new Veiculo(marca, modelo, placa);

		System.out.println("� ve�culo de mensalidade? S/N");
		String resposta = sc.next();
		if(resposta == "N"){
			System.out.println(o_Veiculo.Trace());
			return o_Veiculo;	
		} else {
			Proprietario p = cadastroProprietario(o_Veiculo);
			o_Veiculo.setProprietario(p);
			proprietarios.push( p );
		}

		
	}

	public static void novoAcesso(){

		// escolher ve�culo

		System.out.println("Dia de Acesso:");
		String DataAcesso = sc.next();
		
		System.out.println("Hora de Entrada:");
		String HoraEntrada = sc.next();
		
		System.out.println("Hora de Sa�da:");
		String HoraSaida = sc.next();
		
		Estacionamento o_Estacionamento = new Estacionamento(DataAcesso, HoraEntrada, HoraSaida);
		
		System.out.println(o_Estacionamento.Trace());
	}



	public static void main(String[] args) {
		System.out.println("Bem-vindo ao programa de estacionamento, escolha uma op��o:");
		System.out.println("1 - Cadastrar novo ve�culo");
		System.out.println("2 - Cadastrar novo acesso a ve�culo existente");
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
