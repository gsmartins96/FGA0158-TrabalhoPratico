package oo_estacionamento;

public class DadosAcessoIncompletosException extends Exception{
	public DadosAcessoIncompletosException(String errorMessage, Throwable err){super(errorMessage, err);}
	public DadosAcessoIncompletosException(String errorMessage){super(errorMessage);}
}