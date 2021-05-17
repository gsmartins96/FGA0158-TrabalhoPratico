package oo_estacionamento;

public class Veiculo{
	private String marca;
	private String modelo;
	private String placa;

	private Proprietario proprietario;

	public String getMarca() {
		return null;
	}
	public void setMarca(String marca) {
	}

	public String getModelo() {
		return null;
	}
	public void setModelo(String modelo) {
	}

	public String getPlaca() {
		return null;
	}
	public void setPlaca(String placa) {
	}

	public Proprietario getProprietario() {
		return null;
	}
	public void setProprietario(Proprietario p) {
	}

	//This is constructor of Veiculo Class
	Veiculo(String marca, String modelo, String placa){
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
	}

	public String Trace(){
		return marca + modelo + placa;
	}
}
