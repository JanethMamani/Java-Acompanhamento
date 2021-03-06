package Xadrez;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Tabuleiro.Peca;
import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import Xadrez.Pecas.Bispo;
import Xadrez.Pecas.Cavalo;
import Xadrez.Pecas.Peao;
import Xadrez.Pecas.Queen;
import Xadrez.Pecas.Rei;
import Xadrez.Pecas.Torre;

public class Partida {

	private int turno;
	private Cor jogador;
	private Tabuleiro tabua;
	private boolean cheque;// Por padr?o j? est? como falso
	private boolean xequemate;
	private PecaXadrez enPassantVulneravel;
	private PecaXadrez promocao;

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

	public Cor getJogador() {
		return jogador;
	}

	public boolean getCheque() {
		return cheque;
	}

	public boolean getXequemate() {
		return xequemate;
	}
	
	public PecaXadrez getEnPassantVulneravel(){
		return enPassantVulneravel;
	}
	
	public PecaXadrez getPromocao() {
		return promocao;
	}

	public PecaXadrez[][] getPecas() {
		PecaXadrez[][] malha = new PecaXadrez[tabua.getLinhas()][tabua.getColunas()];
		for (int i = 0; i < tabua.getLinhas(); i++) {
			for (int j = 0; j < tabua.getColunas(); j++) {
				malha[i][j] = (PecaXadrez) tabua.peca(i, j);
			}
		}
		return malha;
	}

	public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoOrigem) {
		Posicao posicao = posicaoOrigem.paraPosicao();
		validarPosicaoOrigem(posicao);
		return tabua.peca(posicao).movimentosPossiveis();
	}

	public PecaXadrez moverPecaXadrez(PosicaoXadrez origem, PosicaoXadrez destino) {
		Posicao orig = origem.paraPosicao();
		Posicao dest = destino.paraPosicao();
		validarPosicaoOrigem(orig);
		validarPosicaoDestino(orig, dest);
		Peca pecaCapturada = facaMover(orig, dest);

		if (testeCheque(jogador)) {
			desfazerMove(orig, dest, pecaCapturada);
			throw new ExceptionXadrez("Voc? n?o pode colocar-se em xeque");
		}
		
		PecaXadrez pecaMovida = (PecaXadrez)tabua.peca(dest);
		
		//Special Promocao
		promocao = null;
		if (pecaMovida instanceof Peao) {
			if((pecaMovida.getCor() == Cor.BRANCO && destino.getLinha() == 8) || (pecaMovida.getCor() == Cor.PRETO && destino.getLinha() == 1)) {
				promocao = (PecaXadrez)tabua.peca(dest);
				promocao = trocarPecaPromovida("Q");
			}
		}
		
		cheque = (testeCheque(oponente(jogador))) ? true : false;

		if (testeXequemate(oponente(jogador))) {
			xequemate = true;
		} else {
			proximoTurno();
		}
		
		// Special move en passant
		if (pecaMovida instanceof Peao && (destino.getLinha() == origem.getLinha() - 2 || destino.getLinha() == origem.getLinha() + 2)) {
			enPassantVulneravel = pecaMovida;
		} else {
			enPassantVulneravel = null;
		}

		return (PecaXadrez) pecaCapturada;
	}
	
	public PecaXadrez trocarPecaPromovida(String type) {
		if (promocao == null) {
			 throw new IllegalStateException("N?o h? peca para ser promovida");
		}
		if(!type.equals("B") && !type.equals("C") && !type.equals("T") & !type.equals("Q")) {
			 return promocao;
		}
		Posicao posi = promocao.getPosicaoXadrez().paraPosicao();
		Peca pecinha = tabua.removerPeca(posi);
		pecasNoTabuleiro.remove(pecinha);
		
		PecaXadrez promovida = novaPeca(type, promocao.getCor());
		tabua.colocarPeca(promovida, posi);
		pecasNoTabuleiro.add(promovida);
		
		return promovida;
	}
		
	private PecaXadrez novaPeca(String type, Cor cor) {
		if (type.equals("B")) return new Bispo(tabua,cor);
		if (type.equals("C")) return new Cavalo(tabua,cor);
		if (type.equals("Q")) return new Queen(tabua,cor);
		return new Torre(tabua,cor);
	}

	private Peca facaMover(Posicao origem, Posicao destino) {
		PecaXadrez pecinha = (PecaXadrez) tabua.removerPeca(origem);
		pecinha.incrementaContadorMovimentos();
		Peca pecaCapturada = tabua.removerPeca(destino);
		tabua.colocarPeca(pecinha, destino);

		if (pecaCapturada != null) {
			pecasNoTabuleiro.remove(pecaCapturada);
			pecasCapturadas.add(pecaCapturada);

		}

		// Fa?a mover King side
		if (pecinha instanceof Rei && destino.getColuna() == origem.getColuna() + 2) {
			Posicao origemTor = new Posicao(origem.getLinha(), origem.getColuna() + 3);
			Posicao destinoTor = new Posicao(origem.getLinha(), origem.getColuna() + 1);
			PecaXadrez torre = (PecaXadrez) tabua.removerPeca(origemTor);
			tabua.colocarPeca(torre, destinoTor);
			torre.incrementaContadorMovimentos();
		}
		// Fa?a mover Queen side
		if (pecinha instanceof Rei && destino.getColuna() == origem.getColuna() - 2) {

		}
		
		//Special En passant
		if (pecinha instanceof Peao) {
			if (origem.getColuna() != destino.getColuna() && pecaCapturada == null) {
				Posicao posicaoPeao;
				if (pecinha.getCor() == Cor.BRANCO) {
					posicaoPeao = new Posicao(destino.getLinha() + 1, destino.getColuna());
				}else {
					posicaoPeao = new Posicao(destino.getLinha() - 1, destino.getColuna());
				}
				pecaCapturada = tabua.removerPeca(posicaoPeao);
				pecasCapturadas.add(pecaCapturada);
				pecasNoTabuleiro.remove(pecaCapturada);
			}
		}

		return pecaCapturada;
	}

	private void desfazerMove(Posicao origem, Posicao destino, Peca pecaCapturada) {
		PecaXadrez pecinha = (PecaXadrez) tabua.removerPeca(destino);
		pecinha.decrementaContadorMovimentos();
		tabua.colocarPeca(pecinha, origem);

		if (pecaCapturada != null) {
			tabua.colocarPeca(pecinha, destino);
			pecasCapturadas.remove(pecaCapturada);
			pecasNoTabuleiro.add(pecaCapturada);
		}

		// Fa?a mover King side
		if (pecinha instanceof Rei && destino.getColuna() == origem.getColuna() + 2) {
			Posicao origemTor = new Posicao(origem.getLinha(), origem.getColuna() + 3);
			Posicao destinoTor = new Posicao(origem.getLinha(), origem.getColuna() + 1);
			PecaXadrez torre = (PecaXadrez) tabua.removerPeca(destinoTor);
			tabua.colocarPeca(torre, origemTor);
			torre.decrementaContadorMovimentos();
		}
		// Fa?a mover Queen side
		if (pecinha instanceof Rei && destino.getColuna() == origem.getColuna() - 2) {
			Posicao origemTor = new Posicao(origem.getLinha(), origem.getColuna() - 4);
			Posicao destinoTor = new Posicao(origem.getLinha(), origem.getColuna() - 1);
			PecaXadrez torre = (PecaXadrez) tabua.removerPeca(destinoTor);
			tabua.colocarPeca(torre, origemTor);
			torre.decrementaContadorMovimentos();
		}
		
		//En passant
		if (pecinha instanceof Peao) {
			if(origem.getColuna() != destino.getColuna() && pecaCapturada == enPassantVulneravel) {
				PecaXadrez peao = (PecaXadrez)tabua.removerPeca(destino);
				Posicao posicaoPeao;
				if(pecinha.getCor() == Cor.BRANCO) {
					posicaoPeao = new Posicao(3, destino.getColuna());
				} else {
					posicaoPeao = new Posicao(4, destino.getColuna());
				}
				tabua.colocarPeca(peao, posicaoPeao);
			}
		}
	}

	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabua.haUmaPeca(posicao)) {
			throw new ExceptionXadrez("N?o h? essa posi??o no tabuleiro de xadrez");
		}
		if (jogador != ((PecaXadrez) tabua.peca(posicao)).getCor()) {
			throw new ExceptionXadrez("A pe?a escolhida n?o ? sua!");
		}
		if (!tabua.peca(posicao).haUmPossivelMovimento()) {
			throw new ExceptionXadrez("N?o h? movimentos poss?veis para a pe?a escolhida.");
		}
	}

	private void validarPosicaoDestino(Posicao origem, Posicao destino) {
		if (!tabua.peca(origem).movimentoPossivel(destino)) {
			throw new ExceptionXadrez("A pe?a escolhida n?o pode mover-se para o destino.");
		}
	}

	private void proximoTurno() {
		turno++;
		jogador = (jogador == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}

	private Cor oponente(Cor cor) {
		return (cor == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}

	private PecaXadrez corRei(Cor cor) {
		List<Peca> reiLista = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez) x).getCor() == cor)
				.collect(Collectors.toList());
		for (Peca pecinha : reiLista) {
			if (pecinha instanceof Rei) {
				return (PecaXadrez) pecinha;
			}
		}
		throw new IllegalStateException("N?o h? nenhum rei " + cor + " no tabuleiro.");
	}

	private boolean testeCheque(Cor cor) {
		Posicao posicaoRei = corRei(cor).getPosicaoXadrez().paraPosicao();
		List<Peca> pecasOponentes = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez) x).getCor() == oponente(cor))
				.collect(Collectors.toList());
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
		List<Peca> pecas = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez) x).getCor() == cor)
				.collect(Collectors.toList());
		for (Peca pecinha : pecas) {
			boolean[][] malha = pecinha.movimentosPossiveis();
			for (int i = 0; i < tabua.getLinhas(); i++) {
				for (int j = 0; j < tabua.getColunas(); j++) {
					if (malha[i][j]) {
						Posicao origem = ((PecaXadrez) pecinha).getPosicaoXadrez().paraPosicao();
						Posicao destino = new Posicao(i, j);
						Peca pecaCapturada = facaMover(origem, destino);
						boolean testeCheque = testeCheque(cor);
						desfazerMove(origem, destino, pecaCapturada);
						if (!testeCheque) {
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
		colocarNovaPeca('e', 8, new Rei(tabua, Cor.PRETO, this));
		colocarNovaPeca('a', 8, new Torre(tabua, Cor.PRETO));
		colocarNovaPeca('h', 8, new Torre(tabua, Cor.PRETO));
		colocarNovaPeca('a', 7, new Peao(tabua, Cor.PRETO,this));
		colocarNovaPeca('b', 7, new Peao(tabua, Cor.PRETO,this));
		colocarNovaPeca('c', 7, new Peao(tabua, Cor.PRETO,this));
		colocarNovaPeca('d', 7, new Peao(tabua, Cor.PRETO,this));
		colocarNovaPeca('e', 7, new Peao(tabua, Cor.PRETO,this));
		colocarNovaPeca('f', 7, new Peao(tabua, Cor.PRETO,this));
		colocarNovaPeca('g', 7, new Peao(tabua, Cor.PRETO,this));
		colocarNovaPeca('h', 7, new Peao(tabua, Cor.PRETO,this));
		colocarNovaPeca('c', 8, new Bispo(tabua, Cor.PRETO));
		colocarNovaPeca('f', 8, new Bispo(tabua, Cor.PRETO));
		colocarNovaPeca('b', 8, new Cavalo(tabua, Cor.PRETO));
		colocarNovaPeca('g', 8, new Cavalo(tabua, Cor.PRETO));
		colocarNovaPeca('d', 8, new Queen(tabua, Cor.PRETO));

		colocarNovaPeca('a', 2, new Peao(tabua, Cor.BRANCO,this));
		colocarNovaPeca('b', 2, new Peao(tabua, Cor.BRANCO,this));
		colocarNovaPeca('c', 2, new Peao(tabua, Cor.BRANCO,this));
		colocarNovaPeca('d', 2, new Peao(tabua, Cor.BRANCO,this));
		colocarNovaPeca('e', 2, new Peao(tabua, Cor.BRANCO,this));
		colocarNovaPeca('f', 2, new Peao(tabua, Cor.BRANCO,this));
		colocarNovaPeca('g', 2, new Peao(tabua, Cor.BRANCO,this));
		colocarNovaPeca('h', 2, new Peao(tabua, Cor.BRANCO,this));
		colocarNovaPeca('e', 1, new Rei(tabua, Cor.BRANCO, this));
		colocarNovaPeca('a', 1, new Torre(tabua, Cor.BRANCO));
		colocarNovaPeca('h', 1, new Torre(tabua, Cor.BRANCO));
		colocarNovaPeca('c', 1, new Bispo(tabua, Cor.BRANCO));
		colocarNovaPeca('f', 1, new Bispo(tabua, Cor.BRANCO));
		colocarNovaPeca('b', 1, new Cavalo(tabua, Cor.BRANCO));
		colocarNovaPeca('g', 1, new Cavalo(tabua, Cor.BRANCO));
		colocarNovaPeca('d', 1, new Queen(tabua, Cor.BRANCO));
	}
}
