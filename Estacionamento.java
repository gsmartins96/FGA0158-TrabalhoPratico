package oo_estacionamento;

public class Estacionamento{
	private String data_acesso;
	private String hora_entrada;
	private String hora_saida;
	private float faturamento;
	private float valorEstacionamento;

	private Proprietario proprietario;

	public String getData_acesso() {
		return null;
	}
	public void setData_acesso(String data_acesso) {
	}

	public String getHora_entrada() {
		return null;
	}
	public void setHora_entrada(String hora_entrada) {
	}

	public String getHora_saida() {
		return null;
	}
	public void setHora_saida(String hora_saida) {
	}

	public float getFaturamento() {
		return 0;
	}
	public void setFaturamento(float faturamento) {
	}

	public float getValorEstacionamento() {
		return 0;
	}
	public void setValorEstacionamento(float valorEstacionamento) {
	}

	//This is constructor of Estacionamento Class
	Estacionamento(String data_acesso, String hora_entrada, String hora_saida){
		this.data_acesso = data_acesso;
		this.hora_entrada = hora_entrada;
		this.hora_saida = hora_saida;
	}
	
	public float calcularPreco(){
		return faturamento;
		
	}

	public void zerarFaturamento(){
		
	}
	
	public String Trace(){
		return data_acesso + hora_entrada + hora_saida;
	}
}
