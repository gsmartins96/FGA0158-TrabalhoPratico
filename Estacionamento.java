package oo_estacionamento;

public class Estacionamento{
	private String data_acesso;
	private String hora_entrada;
	private String hora_saida;
	private float faturamento;
	private float valorEstacionamento;
	private static int hora_abertura = 6*60;
	private static int hora_fechamento = 6*20;
	
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

	public float getFaturamento() {
		return faturamento;
	}
	public void setFaturamento(float faturamento) {
		this.faturamento = faturamento;
	}

	public float getValorEstacionamento() {
		return valorEstacionamento;
	}
	public void setValorEstacionamento(float valorEstacionamento) {
		this.valorEstacionamento = valorEstacionamento;
	}

	//This is constructor of Estacionamento Class
	Estacionamento(String data_acesso, String hora_entrada, String hora_saida){
		this.data_acesso = data_acesso;
		this.hora_entrada = hora_entrada;
		this.hora_saida = hora_saida;
	}
	
	public void calcularPreco(boolean mensalista){
		
				// Obter tempo em minutos
		// Guardar hora e minuto de entrada
		String HEsplit[] = this.hora_entrada.split(":");
		int HoraEntrada = Integer.parseInt(HEsplit[0]);
		int MinutoEntrada = Integer.parseInt(HEsplit[1]);
		// Guardar hora e minuto de saida
		
		String HSsplit[] = this.hora_saida.split(":");
		int HoraSaida = Integer.parseInt(HSsplit[0]);
		int MinutoSaida = Integer.parseInt(HSsplit[1]);
		
		// Converte para apenas minutos
		int Tin = HoraEntrada*60+MinutoEntrada;
		int Tout = HoraSaida*60+MinutoSaida;
		
		// Calcula o tempo de estadia (em minutos)
		int Estadia = Tin - Tout; // AQUI ESTÁ O TEMPO DE ESTADIA EM MINUTOS
		
		
		
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
		} else if(pernoite){
			// R$30
			valorEstacionamento = 30;
		} else if (HORA>9h) {
			// R$110
			valorMinuto = 0.2f;
			valorEstacionamento = 110;
			estadia = 0;			
			descontoHora = 0;

			HORASPERMANECIDAS = HORASPERMANECIDAS - 9;
			descontoHora = HORASPERMANECIDAS * 1;
			if (MINUTOSPERMANECIDOS >= 15) {
				aux = MINUTOSPERMANECIDOS / 15;
				descontoMinuto = aux * 6,5f;
				aux = MINUTOSPERMANECIDOS % 15;
				aux = 0 + (MINUTOSPERMANECIDOS * 0,5)
			}
			else {
				aux = MINUTOSPERMANECIDOS * 0,5;
			}

			estadia = estadia + valorEstacionamento;
			estadia = estadia + (MINUTOSPERMANECIDOS * valorMinuto);
			estadia = estadia + aux;
			estadia = estadia - descontoHora;
			estadia = estadia - descontoMinuto;
			
			// diminui 9h do tempo de estacionamento
			// divide o tempo restante em minutos e multiplica isso por valorMinuto, adiciona a valorEstacionamento
			// divide o tempo restante em horas e aplica o desconto no valorEstacionamento
			// diminui as horas do tempo restante e divide isso por 15min, multiplica por 0.5f e aplica o desconto no valorEstacionamento

		} else { 
			//HORAS < 9
			estadia = 0;

			estadia = HORASPERMANECIDAS * 25;

			if (MINUTOSPERMANECIDOS >= 15) {
				aux = MINUTOSPERMANECIDOS / 15;
				descontoMinuto = aux * 6,5f;
				aux = MINUTOSPERMANECIDOS % 15;
				aux = 0 + (MINUTOSPERMANECIDOS * 0,5)
			}
			else {
				aux = MINUTOSPERMANECIDOS * 0,5;
			}
			
			estadia = estadia + aux;
			estadia = estadia - descontoHora;
			estadia = estadia - descontoMinuto;

			// divide o tempo restante em minutos e multiplica isso por valorMinuto, adiciona a valorEstacionamento
			// divide o tempo restante em horas e aplica o desconto no valorEstacionamento
			// diminui as horas do tempo restante e divide isso por 15min, multiplica por 0.5f e aplica o desconto no valorEstacionamento
		}
	}

	public void zerarFaturamento(){
		this.faturamento = 0;
	}
	
	public String Trace(){
		return data_acesso + hora_entrada + hora_saida;
	}
}
