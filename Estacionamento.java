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

		calcularPreco();
	}

	private float calculoEstadia(int minutosPermanecidos, float precoMinuto){
		float valorPago = precoMinuto * minutosPermanecidos;

		// Desconto hora
		while(minutosPermanecidos >= 60){
			valorPago -= minutosPermanecidos/60;
			minutosPermanecidos = minutosPermanecidos/60;
		}

		// Desconto 15min
		while(minutosPermanecidos >= 15){
			valorPago -= (minutosPermanecidos/15) * (0.5f);
			minutosPermanecidos = minutosPermanecidos/15;
		}

		return valorPago;
	}
	
	public void calcularPreco(){
		
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

		float valorMinuto = 0.5f;
		valorEstacionamento = calculoEstadia(estadia, valorMinuto);
		faturamento += valorEstacionamento;
		
		return;
	}
}
