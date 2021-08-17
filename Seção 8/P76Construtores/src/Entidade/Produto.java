package Entidade;

public class Produto {
	
	private String name;
	private double preco;
	private int quantidade;
	
	//Construtor padrão
	/*
	public Produto() {
		
	}
	*/
	
	//Contrutor personalizado que pede quantidade
	public Produto(String Nome, double Preco, int Quant) {//Por convenção deveria ter usado os mesmos nomes
		name = Nome; //this.name = Nome;
		this.preco = Preco;
		this.quantidade = Quant;
	}
	
	
	//Construtor que zera o estoque
	public Produto(String Nome, double Preco) {
		name = Nome;
		preco = Preco;
		quantidade = 0; //this.quantidade = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String Nome) {
		name = Nome;
	}
	
	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public int getQuantidade() {
		return quantidade;
	}

	
	
	public double totalemEstoque() {
		return preco * quantidade;
	}
	
	public void addProduto(int quantity) {
		this.quantidade += quantity; //this fazendo referencia ao 'quantidade'
		
	}
	
	public void removerProduto(int quantity){
		this.quantidade -= quantity;
	}
	
	public String toString(){ //Sobrepondo o toString
		
		return name 
				+ ", $ " 
				+ String.format("%.2f", preco) 
				+ ", " 
				+ quantidade 
				+ " unidades. Total: $ " 
				+ String.format("%.2f", totalemEstoque());
	}

}
