package oo_estacionamento;

public class DadosPessoaisIncompletosException extends Exception{
	public DadosPessoaisIncompletosException(String errorMessage, Throwable err){super(errorMessage, err);}
	public DadosPessoaisIncompletosException(String errorMessage){super(errorMessage);}
}
public class DadosVeiculosIncompletosException extends Exception{
	public DadosVeiculosIncompletosException(String errorMessage, Throwable err){super(errorMessage, err);}
	public DadosVeiculosIncompletosException(String errorMessage){super(errorMessage);}
}
public class DadosAcessoIncompletosException extends Exception{
	public DadosAcessoIncompletosException(String errorMessage, Throwable err){super(errorMessage, err);}
	public DadosAcessoIncompletosException(String errorMessage){super(errorMessage);}
}
public class EstacionamentoFechadoException extends Exception{
	public EstacionamentoFechadoException(String errorMessage, Throwable err){super(errorMessage, err);}
	public EstacionamentoFechadoException(String errorMessage){super(errorMessage);}
}
public class PeriodoInvalidoException extends Exception{
	public PeriodoInvalidoException(String errorMessage, Throwable err){super(errorMessage, err);}
	public PeriodoInvalidoException(String errorMessage){super(errorMessage);}
}
