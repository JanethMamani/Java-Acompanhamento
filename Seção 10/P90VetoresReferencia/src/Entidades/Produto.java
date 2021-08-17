package Entidades;

public class Produto {
	
	private String nome;
	private double preco;
	
	public Produto(String oNome, double entraPreco) {
		nome = oNome;
		preco = entraPreco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double entraPreco) {
		preco = entraPreco;
	}

}
