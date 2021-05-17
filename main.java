package Classes;

import java.util.Scanner;

import java.text.SimpleDateFormat;  
import java.util.Date;  

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dia de Acesso:");
		String DataAcesso = sc.next();
		
		System.out.println("Hora de Entrada:");
		String HoraEntrada = sc.next();
		
		System.out.println("Hora de Saída:");
		String HoraSaida = sc.next();
		
		Estacionamento o_Estacionamento = new Estacionamento(DataAcesso, HoraEntrada, HoraSaida);
		
		System.out.println(o_Estacionamento.Trace());
	}
}