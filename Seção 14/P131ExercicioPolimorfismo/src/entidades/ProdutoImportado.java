package entidades;

public class ProdutoImportado extends Produto{
	
	private Double precoAlfandega;
	
	public ProdutoImportado() {
		super();
	}

	public ProdutoImportado(String nome, Double preco, Double precoAlfandega) {
		super(nome, preco);
		this.precoAlfandega = precoAlfandega;
	}

	public Double getPrecoAlfandega() {
		return precoAlfandega;
	}

	public void setPrecoAlfandega(Double precoAlfandega) {
		this.precoAlfandega = precoAlfandega;
	}
	
	
}
