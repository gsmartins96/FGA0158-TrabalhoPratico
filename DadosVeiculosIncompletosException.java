package oo_estacionamento;

public class DadosVeiculosIncompletosException extends Exception{
	public DadosVeiculosIncompletosException(String errorMessage, Throwable err){super(errorMessage, err);}
	public DadosVeiculosIncompletosException(String errorMessage){super(errorMessage);}
}