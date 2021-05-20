package estacionamento_oo;

public class EstacionamentoDiaria extends Estacionamento{

	EstacionamentoDiaria(String dataAcesso, String horaEntrada, String horaSaida, Veiculo v){
		super(dataAcesso, horaEntrada, horaSaida, v);
	}

	@Override
	public void calcularPreco(){
		String HEsplit[] = this.hora_entrada.split(":");
		int horaEntrada = Integer.parseInt(HEsplit[0]);
		int minutoEntrada = Integer.parseInt(HEsplit[1]);
		// Guardar hora e minuto de saida
		
		String HSsplit[] = this.hora_saida.split(":");
		int horaSaida = Integer.parseInt(HSsplit[0]);
		int minutoSaida = Integer.parseInt(HSsplit[1]);
		
		// Converte para apenas minutos
		int tin = horaEntrada*60+minutoEntrada;
		int tout = horaSaida*60+minutoSaida;
		
		// Calcula o tempo de estadia (em minutos)
		int estadia = tout - tin; // AQUI ESTÁ O TEMPO DE ESTADIA EM MINUTOS
		
		float valorMinuto = 0.2f;
		valorEstacionamento = 110;
		valorEstacionamento += calculoEstadia(estadia - 9*60, valorMinuto);
		faturamento += valorEstacionamento;
	}
}
