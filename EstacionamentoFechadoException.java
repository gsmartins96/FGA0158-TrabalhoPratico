package oo_estacionamento;

public class EstacionamentoFechadoException extends Exception{
	public EstacionamentoFechadoException(String errorMessage, Throwable err){super(errorMessage, err);}
	public EstacionamentoFechadoException(String errorMessage){super(errorMessage);}
}
