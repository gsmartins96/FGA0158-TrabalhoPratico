package estacionamentoOO;

public class Proprietario{
	private String nome;
	private String endereco;
	private int celular;
	private int telefone;
	private int cnh;

	private Veiculo[] veiculos;

	public String getNome();
	public void setNome(String nome);

	public String getEndereco();
	public void setEndereco(String endereco);

	public int getCelular();
	public void setCelular(int celular);

	public int getTelefone();
	public void setTelefone(int telefone);

	public int getCNH();
	public void setCNH(int cnh);

	public Veiculo getVeiculo(int index);
	public void addVeiculo(Veiculo v);


	//This is constructor of Proprietario Class
	Proprietario(String nome, String endereco, int celular, int telefone, int cnh){
		this.nome = nome;
		this.endereco = endereco;
		this.celular = celular;
		this.telefone = telefone;
		this.cnh = cnh;
	}
}