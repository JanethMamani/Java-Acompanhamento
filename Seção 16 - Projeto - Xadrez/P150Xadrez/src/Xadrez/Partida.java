package Xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Tabuleiro.Peca;
import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import Xadrez.Pecas.Rei;
import Xadrez.Pecas.Torre;

public class Partida {
	
	private int turno;
	private Cor jogador;
	private Tabuleiro tabua;
	private boolean cheque;//Por padrão já está como falso
	private boolean xequemate;
	
	private List<Peca> pecasNoTabuleiro = new ArrayList<>();
	private List<Peca> pecasCapturadas = new ArrayList<>();
	
	public Partida() {
		tabua = new Tabuleiro(8, 8);
		turno = 1;
		jogador = Cor.BRANCO;
		setupInicial();
		cheque = false;
	}
	
	public int getTurno() {
		return turno;
	}
	
	public Cor getJogador(){
		return jogador;
	}
	
	public boolean getCheque() {
		return cheque;
	}
	
	public boolean getXequemate() {
		return xequemate;
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
		
		if (testeCheque(jogador)) {
			desfazerMove(orig, dest, pecaCapturada);
			throw new ExceptionXadrez("Você não pode colocar-se em xeque");
		}
		cheque = (testeCheque(oponente(jogador))) ? true : false;
		
		if (testeXequemate(oponente(jogador))) {
			xequemate = true;
		}
		else {
			proximoTurno();
		}
		
		return (PecaXadrez)pecaCapturada;
	}
	
	private Peca facaMover(Posicao origem, Posicao destino) {
		Peca pecinha = tabua.removerPeca(origem);
		Peca pecaCapturada = tabua.removerPeca(destino);
		tabua.colocarPeca(pecinha, destino);
		
		if (pecaCapturada != null) {
			pecasNoTabuleiro.remove(pecaCapturada);
			pecasCapturadas.add(pecaCapturada);
			
		}
		return pecaCapturada;
	}
	
	private void desfazerMove(Posicao origem, Posicao destino, Peca pecaCapturada) {
		Peca pecinha = tabua.removerPeca(destino);
		tabua.colocarPeca(pecinha, origem);
		
		if(pecaCapturada != null) {
			tabua.colocarPeca(pecinha, destino);
			pecasCapturadas.remove(pecaCapturada);
			pecasNoTabuleiro.add(pecaCapturada);
			}
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabua.haUmaPeca(posicao)) {
			throw new ExceptionXadrez("Não há essa posição no tabuleiro de xadrez");
		}
		if(jogador != ((PecaXadrez)tabua.peca(posicao)).getCor()) {
			throw new ExceptionXadrez("A peça escolhida não é sua!");
		}
		if(!tabua.peca(posicao).haUmPossivelMovimento()) {
			throw new ExceptionXadrez("Não há movimentos possíveis para a peça escolhida.");
		}
	}
	
	private void validarPosicaoDestino(Posicao origem, Posicao destino) {
		if(!tabua.peca(origem).movimentoPossivel(destino)) {
			throw new ExceptionXadrez("A peça escolhida não pode mover-se para o destino.");
		}
	}
	
	private void proximoTurno() {
		turno++;
		jogador = (jogador == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}
	
	private Cor oponente(Cor cor) {
		return(cor == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}
	
	private PecaXadrez corRei(Cor cor) {
		List<Peca> reiLista = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == cor).collect(Collectors.toList());
		for (Peca pecinha : reiLista) {
			if(pecinha instanceof Rei) {
				return (PecaXadrez)pecinha;
			}
		}
		throw new IllegalStateException("Não há nenhum rei " + cor + " no tabuleiro.");
	}
	
	private boolean testeCheque(Cor cor) {
		Posicao posicaoRei = corRei(cor).getPosicaoXadrez().paraPosicao();
		List<Peca> pecasOponentes = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == oponente(cor)).collect(Collectors.toList());
		for (Peca pecinha : pecasOponentes) {
			boolean[][] malha = pecinha.movimentosPossiveis();
			if (malha[posicaoRei.getLinha()][posicaoRei.getColuna()]) {
				return true;
			}
		}
		return false;
	}
	
	private boolean testeXequemate(Cor cor) {
		if (!testeCheque(cor)) {
			return false;
		}
		List<Peca> pecas = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == cor).collect(Collectors.toList());
		for (Peca pecinha : pecas) {
			boolean[][] malha = pecinha.movimentosPossiveis();
			for(int i=0; i<tabua.getLinhas(); i++) {
				for(int j=0; j<tabua.getColunas(); j++) {
					if(malha[i][j]) {
						Posicao origem = ((PecaXadrez)pecinha).getPosicaoXadrez().paraPosicao();
						Posicao destino = new Posicao(i,j);
						Peca pecaCapturada = facaMover(origem, destino);
						boolean testeCheque = testeCheque(cor);
						desfazerMove(origem, destino, pecaCapturada);
						if(!testeCheque) {
							return false;
						}
						
					}
				}
			}
		}
		return true;
	}
	
	private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabua.colocarPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
		pecasNoTabuleiro.add(peca);
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
