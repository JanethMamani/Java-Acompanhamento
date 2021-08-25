package Tabuleiro;

public class ExceptionTabuleiro extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ExceptionTabuleiro(String mensagem) {
		super(mensagem);
	}
}
