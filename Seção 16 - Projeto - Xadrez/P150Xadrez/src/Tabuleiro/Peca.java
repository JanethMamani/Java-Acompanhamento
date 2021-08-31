package Tabuleiro;

public abstract class Peca {
	
	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;//Por padrao ja vem nulo
	}
	
	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	public abstract boolean[][] movimentosPossiveis();
	
	public boolean movimentoPossivel(Posicao posicao) {
		return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
	}
	
	public boolean haUmPossivelMovimento() {
		boolean[][] malha = movimentosPossiveis();
		for(int i=0; i<malha.length; i++) {
			for(int j=0; j<malha.length; j++) {
				if(malha[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

}
