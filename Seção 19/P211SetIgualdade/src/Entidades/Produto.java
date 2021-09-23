package Entidades;

import java.util.Objects;

public class Produto implements Comparable<Produto>{
	
	private double preco;
	private String nome;
	
	public Produto(String nome, double preco) {
	
		this.preco = preco;
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
	}

	@Override
	public String toString() {
		return "Produto [preco=" + preco + ", nome=" + nome + "]";
	}

	@Override
	public int compareTo(Produto outro) {
		// TODO Auto-generated method stub
		return nome.toUpperCase().compareTo(outro.getNome().toUpperCase());
	}
	
}
