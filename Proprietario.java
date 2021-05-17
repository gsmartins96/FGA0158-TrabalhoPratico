package oo_estacionamento;

public class Proprietario{
	private String nome;
	private String endereco;
	private int celular;
	private int telefone;
	private int cnh;

	private Veiculo[] veiculos;

	public String getNome() {
		return null;
	}
	public void setNome(String nome) {
	}

	public String getEndereco() {
		return null;
	}
	public void setEndereco(String endereco) {
	}

	public int getCelular() {
		return 0;
	}
	public void setCelular(int celular) {
	}

	public int getTelefone() {
		return 0;
	}
	public void setTelefone(int telefone) {
	}

	public int getCNH() {
		return 0;
	}
	public void setCNH(int cnh) {
	}

	public Veiculo getVeiculo(int index) {
		return null;
	}
	public void addVeiculo(Veiculo v) {
	}


	//This is constructor of Proprietario Class
	Proprietario(String nome, String endereco, int celular, int telefone, int cnh){
		this.nome = nome;
		this.endereco = endereco;
		this.celular = celular;
		this.telefone = telefone;
		this.cnh = cnh;
	}

	public Proprietario(String nome2, String endereco2, String celular2, String telefone2, String cnh2) {
		// TODO Auto-generated constructor stub
	}
	public String Trace(){
		return "";
	}
}
