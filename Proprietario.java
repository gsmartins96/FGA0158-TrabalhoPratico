package oo_estacionamento;

import java.util.ArrayList;

public class Proprietario{
	private String nome;
	private String endereco;
	private int celular;
	private int telefone;
	private int cnh;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}

	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getCNH() {
		return cnh;
	}
	public void setCNH(int cnh) {
		this.cnh = cnh;
	}

	//This is constructor of Proprietario Class
	Proprietario(String nome, String endereco, int celular, int telefone, int cnh){
		this.nome = nome;
		this.endereco = endereco;
		this.celular = celular;
		this.telefone = telefone;
		this.cnh = cnh;
	}
}
