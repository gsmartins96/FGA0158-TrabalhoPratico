package oo_estacionamento;

public class PeriodoInvalidoException extends Exception{
	public PeriodoInvalidoException(String errorMessage, Throwable err){super(errorMessage, err);}
	public PeriodoInvalidoException(String errorMessage){super(errorMessage);}
}