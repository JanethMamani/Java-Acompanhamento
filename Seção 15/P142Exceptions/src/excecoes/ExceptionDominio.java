package excecoes;


public class ExceptionDominio extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ExceptionDominio(String mensagem) {
		super(mensagem);
	}

}
