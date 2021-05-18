package Classes;

// Estas são as duas bibliotecas nescessarias (importei completas)
import java.text.*;
import java.util.*;

public class StringToInt {
	
	public static void main(String[] args) throws ParseException {
//		Scanner sc = new Scanner(System.in);	// intancia o scanner como sc
		
//		System.out.println("Hora da Entrada(K:mm):");
//		String DataTextin = sc.next();	// String lida e armazenada
		String DataTextin = "20:35";
		
		String HorasText[] = DataTextin.split(":");
		
		int Horas = Integer.parseInt(HorasText[0]);
		int Minutos = Integer.parseInt(HorasText[1]);
		
		System.out.println(Horas+"   :   "+Minutos);	// Printa a data no formato Date
	}
}