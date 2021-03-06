package Servico;

import java.util.Date;

import Entidades.Filme;
import Entidades.Locacao;
import Entidades.Usuario;
import Exceptions.FilmeSemEstoqueExcep;
import Exceptions.LocadoraException;
import Utilitarios.DataUtilid;

public class LocacaoServico {
	
	public Locacao  alugarFilme(Usuario usuario, Filme filme) throws FilmeSemEstoqueExcep, LocadoraException {
		if(filme == null) {
			throw new LocadoraException("Filme vazio");//Atentar-se as ordens dos ifs
		}
		
		if(filme.getEstoque() == 0) {
			throw new FilmeSemEstoqueExcep();
		}
		
		if(usuario == null) {
			throw new LocadoraException("Usuario vazio");
		}
		
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());
		
		Date dataEntrega = new Date();
		dataEntrega = DataUtilid.adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		return locacao;
	}
	
	

}
