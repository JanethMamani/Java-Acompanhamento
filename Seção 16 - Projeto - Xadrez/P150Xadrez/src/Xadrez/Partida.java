package Xadrez;

import Tabuleiro.Peca;
import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import Xadrez.Pecas.Rei;
import Xadrez.Pecas.Torre;

public class Partida {
	
	private int turno;
	private Cor jogador;
	private Tabuleiro tabua;
	
	public Partida() {
		tabua = new Tabuleiro(8, 8);
		turno = 1;
		jogador = Cor.BRANCO;
		setupInicial();
	}
	
	public int getTurno() {
		return turno;
	}
	
	public Cor getJogador(){
		return jogador;
	}
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] malha = new PecaXadrez[tabua.getLinhas()][tabua.getColunas()];
		for (int i=0; i<tabua.getLinhas(); i++) {
			for(int j=0; j<tabua.getColunas(); j++) {
				malha[i][j] = (PecaXadrez) tabua.peca(i, j);
			}
		}
		return malha;
	}
	
	public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoOrigem){
		Posicao posicao = posicaoOrigem.paraPosicao();
		validarPosicaoOrigem(posicao);
		return tabua.peca(posicao).movimentosPossiveis();
	}
	
	public PecaXadrez moverPecaXadrez(PosicaoXadrez origem, PosicaoXadrez destino) {
		Posicao orig = origem.paraPosicao();
		Posicao dest = destino.paraPosicao();
		validarPosicaoOrigem(orig);
		validarPosicaoDestino(orig, dest);
		Peca pecaCapturada = facaMover(orig,dest);
		proximoTurno();
		return (PecaXadrez)pecaCapturada;
	}
	
	private Peca facaMover(Posicao origem, Posicao destino) {
		Peca pecinha = tabua.removerPeca(origem);
		Peca pecaCapturada = tabua.removerPeca(destino);
		tabua.colocarPeca(pecinha, destino);
		return pecaCapturada;
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabua.haUmaPeca(posicao)) {
			throw new ExceptionXadrez("N�o h� essa posi��o no tabuleiro de xadrez");
		}
		if(jogador != ((PecaXadrez)tabua.peca(posicao)).getCor()) {
			throw new ExceptionXadrez("A pe�a escolhida n�o � sua!");
		}
		if(!tabua.peca(posicao).haUmPossivelMovimento()) {
			throw new ExceptionXadrez("N�o h� movimentos poss�veis para a pe�a escolhida.");
		}
	}
	
	private void validarPosicaoDestino(Posicao origem, Posicao destino) {
		if(!tabua.peca(origem).movimentoPossivel(destino)) {
			throw new ExceptionXadrez("A pe�a escolhida n�o pode mover-se para o destino.");
		}
	}
	
	private void proximoTurno() {
		turno++;
		jogador = (jogador == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}
	
	private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabua.colocarPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
	}
	
	private void setupInicial() {
		colocarNovaPeca('e', 8, new Rei(tabua, Cor.BRANCO));
		colocarNovaPeca('a', 8, new Torre(tabua, Cor.BRANCO));
		colocarNovaPeca('h', 8, new Torre(tabua, Cor.BRANCO));
		colocarNovaPeca('e', 1, new Rei(tabua, Cor.PRETO));
		colocarNovaPeca('a', 1, new Torre(tabua, Cor.PRETO));
		colocarNovaPeca('h', 1, new Torre(tabua, Cor.PRETO));
	}
}
