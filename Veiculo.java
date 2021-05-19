package oo_estacionamento;

public class Veiculo{
	private String marca;
	private String modelo;
	private String placa;
	private boolean p;

	private Proprietario proprietario;

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public boolean getProprietario() {
		return p;
	}
	public void setProprietario(Proprietario p) {
		this.proprietario = proprietario;
		this.p = true;
	}

	//This is constructor of Veiculo Class
	Veiculo(String marca, String modelo, String placa){
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		proprietario = null;
		this.p = false;
	}
}
