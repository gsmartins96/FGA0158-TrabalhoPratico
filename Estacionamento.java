package oo_estacionamento;

public class Estacionamento{
	private String data_acesso;
	private String hora_entrada;
	private String hora_saida;
	private float valorEstacionamento;

	private static float faturamento;
	private static int hora_abertura = 6*60;
	private static int hora_fechamento = 60*20;

	private Veiculo veiculo;
	
	public String getData_acesso() {
		return data_acesso;
	}
	public void setData_acesso(String data_acesso) {
		this.data_acesso = data_acesso;
	}

	public String getHora_entrada() {
		return hora_entrada;
	}
	public void setHora_entrada(String hora_entrada) {
		this.hora_entrada = hora_entrada;
	}

	public String getHora_saida() {
		return hora_saida;
	}
	public void setHora_saida(String hora_saida) {
		this.hora_saida = hora_saida;
	}

	public static float getFaturamento() {
		return faturamento;
	}

	public void zerarFaturamento(){
		this.faturamento = 0;
	}
	
	public float getValorEstacionamento() {
		return valorEstacionamento;
	}

	//This is constructor of Estacionamento Class
	Estacionamento(String data_acesso, String hora_entrada, String hora_saida, Veiculo v){
		this.data_acesso = data_acesso;
		this.hora_entrada = hora_entrada;
		this.hora_saida = hora_saida;
		this.veiculo = v;

		calcularPreco(v.getProprietario());
	}

	private float calculoEstadia(int minutosPermanecidos, float precoMinuto){
		float valorPago = precoMinuto * minutosPermanecidos;
		while(minutosPermanecidos >= 60){
			valorPago -= minutosPermanecidos/60;
			minutosPermanecidos = minutosPermanecidos/60;
		}

		while(minutosPermanecidos >= 15){
			valorPago -= (minutosPermanecidos/15) * (0.5f);
			minutosPermanecidos = minutosPermanecidos/15;
		}

		return valorPago;
	}
	
	public void calcularPreco(boolean mensalista){
		
		// Obter tempo em minutos
		// Guardar hora e minuto de entrada
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
		
		// fazer o calculo baseado no tempo de estacionamento

		// a cada minuto - 50c
		// fração de 15min - desconto de 50c
		// hora cheia - desconto de R$1
		// diária (>9h dentro de um dia) - R$110 e minuto excedente valendo 20c
		// pernoite - R$30
		// mensalista - taxa única de R$500 por mês por carro

		float valorMinuto = 0.5f;
		if(mensalista){
			// R$500

			valorEstacionamento = 500;

		} else if(tin >= tout){
			// R$30 + cálculo até 20h e cálculo depois de 6h

			valorEstacionamento = 30;
			valorEstacionamento += calculoEstadia(hora_fechamento - tin, valorMinuto);
			valorEstacionamento += calculoEstadia(tout - hora_abertura, valorMinuto);

		} else if (estadia/60 >= 9) {
			// R$110 + cálculo do tempo restante
			
			valorMinuto = 0.2f;
			valorEstacionamento = 110;
			valorEstacionamento += calculoEstadia(estadia - 9*60, valorMinuto);

		} else { 
			// cálculo do tempo
			
			valorEstacionamento = calculoEstadia(estadia, valorMinuto);

		}

		faturamento += valorEstacionamento;
		// imprimir getValorEstacionamento() na MAIN
		
		return;
	}
}
