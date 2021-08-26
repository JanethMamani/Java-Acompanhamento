package Xadrez;

public class ExceptionXadrez extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ExceptionXadrez(String mensagem) {
		super(mensagem);
	}
}
