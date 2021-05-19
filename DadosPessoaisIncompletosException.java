package oo_estacionamento;

public class DadosPessoaisIncompletosException extends Exception{
	public DadosPessoaisIncompletosException(String errorMessage, Throwable err){super(errorMessage, err);}
	public DadosPessoaisIncompletosException(String errorMessage){super(errorMessage);}
}



