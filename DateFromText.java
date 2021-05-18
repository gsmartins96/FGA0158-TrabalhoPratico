package Classes;

// Estas são as duas bibliotecas nescessarias (importei completas)
import java.text.*;
import java.util.*;

public class DataFromText {
	Date Data;
	
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Data de entrada(dd/mm/aaaa):");
		String DataText = sc.next();	// String lida e armazenada
		
		SimpleDateFormat Data1 = new SimpleDateFormat("dd/MM/yyyy");	// Aqui é possivel Escolher o formato
		Date Data2 = Data1.parse(DataText);	// "Interpreta" o conteudo da string e transforma em Date
		
		System.out.println(Data2);	// Printa a data no formato Date
	}
}
