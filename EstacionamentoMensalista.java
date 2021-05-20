package oo_estacionamento;

public class EstacionamentoMensalista extends Estacionamento{

	EstacionamentoMensalista(){
		super();
	}

	@Override
	public void calcularPreco(){
		valorEstacionamento = 500;
		faturamento += valorEstacionamento;
	}
}