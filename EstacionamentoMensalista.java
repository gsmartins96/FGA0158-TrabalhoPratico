package estacionamento_oo;

public class EstacionamentoMensalista extends Estacionamento{

	EstacionamentoMensalista(String dataAcesso, String horaEntrada, String horaSaida, Veiculo v){
		super(dataAcesso, horaEntrada, horaSaida, v);
	}

	@Override
	public void calcularPreco(){
		valorEstacionamento = 500;
		faturamento += valorEstacionamento;
	}
}
