package estacionamento_oo2;

public class EstacionamentoPernoite extends Estacionamento{

	EstacionamentoPernoite(String dataAcesso, String horaEntrada, String horaSaida, Veiculo v){
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
		
		float valorMinuto = 0.5f;
		valorEstacionamento = 30;
		valorEstacionamento += calculoEstadia(60*20 - tin, valorMinuto);
		valorEstacionamento += calculoEstadia(tout - 60*6, valorMinuto);
		faturamento += valorEstacionamento;
	}
}
