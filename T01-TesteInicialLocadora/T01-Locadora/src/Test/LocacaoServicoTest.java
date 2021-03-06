package Test;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import Entidades.Filme;
import Entidades.Locacao;
import Entidades.Usuario;
import Exceptions.FilmeSemEstoqueExcep;
import Exceptions.LocadoraException;
import Servico.LocacaoServico;
import Utilitarios.DataUtilid;

public class LocacaoServicoTest {
	LocacaoServico servico;
	int contador;
	
	@Rule
	public ErrorCollector erro = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@BeforeClass
	public void antesTodas() {
		int contador = 0;
	}
	
	@Before
	public void configuracoesIniciais() {
		System.out.println("Before");
		LocacaoServico servico = new LocacaoServico();
		contador ++;
		System.out.println(contador);
	}
	
	@After
	public void apos() {
		System.out.println("Depois: recomendado fechar conex?es");
	}
	
	@Test
	public void teste() throws Exception { //O JUnit pode gerenciar se a exce??o for lan?ada
		//LocacaoServico servico = new LocacaoServico();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme aleatorio", 2, 5.0);
		
		Locacao locacao = servico.alugarFilme(usuario, filme);
		
		Assert.assertEquals(5.0, locacao.getValor(), 0.01);//Ordem
		Assert.assertThat(locacao.getValor(), CoreMatchers.is(CoreMatchers.equalTo(5.0)));
		//Se falhar trava aqui, o erro.checkThat permite verifica??o mesmo se alinha falhar
		erro.checkThat(DataUtilid.isMesmaData(locacao.getDataLocacao(), new Date()), CoreMatchers.is(true));
		erro.checkThat(DataUtilid.isMesmaData(locacao.getDataRetorno(), DataUtilid.obterDataComDiferenciaDias(1)), CoreMatchers.is(true));
	}
	
	@Test(expected=FilmeSemEstoqueExcep.class)
	public void testLocacao_filmeSemEstoque() throws Exception{
		//LocacaoServico servico  = new LocacaoServico();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 0, 5.0);
		
		servico.alugarFilme(usuario, filme);
	}
	
	@Test
	public void testLocacao_usuarioVazio() throws FilmeSemEstoqueExcep {
		//LocacaoServico servico = new LocacaoServico();
		Filme filme = new Filme("Filme 2", 1, 4.0);
		
		try {
			servico.alugarFilme(null, filme);
			Assert.fail();
		} catch (LocadoraException semUsuario) {
			Assert.assertThat(semUsuario.getMessage(), CoreMatchers.is("Usuario vazio"));
		}
		
		System.out.println("A forma robusta permite que o c?digo continue ap?s a exce??o");
	}
	
	@Test
	public void testeLocacao_FilmeVazio() throws FilmeSemEstoqueExcep, LocadoraException {
		//LocacaoServico servico = new LocacaoServico();
		Usuario usuario = new Usuario("Usuario 1");
		
		exception.expect(LocadoraException.class);
		exception.expectMessage("Filme vazio");
		
		servico.alugarFilme(usuario, null);
		
		System.out.println("A forma nova n?o permite que o c?digo continue depois de dar exce??o");
	}
	
	/*
	@Test
	public void testeLocacao_filmeSemEstoque_Robusto() {
		LocacaoServico servico = new LocacaoServico();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 0, 5.0);
		
		try {
			servico.alugarFilme(usuario, filme);
			Assert.fail("Deveria ter lan?ado uma exce??o.");
		} catch (Exception e) {
			//O texto deve ser igual para comparar o core matcher
			Assert.assertThat(e.getMessage(), CoreMatchers.is("Sem filme no estoque."));
		}
	}
	
	@Test
	public void testeLocacao_filmeSemEstoque_porTexto_FormaNova() throws Exception {
		LocacaoServico servico = new LocacaoServico();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 0, 5.0);
		
		exception.expect(Exception.class);
		exception.expectMessage("Sem filme no estoque.");
		
		servico.alugarFilme(usuario, filme);
	}
	*/

}
