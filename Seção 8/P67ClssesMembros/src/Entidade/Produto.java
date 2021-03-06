package Entidade;

public class Produto {
	
	public String name;
	public double preco;
	public int quantidade;
	
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
