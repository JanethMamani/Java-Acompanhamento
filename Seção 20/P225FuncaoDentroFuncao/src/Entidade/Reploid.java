package Entidade;

public class Reploid {
	
	private String nome;
	private String rank;
	private double hp;
	private int idade;
	
	public Reploid(String nome, String rank, double hp, int idade) {
		super();
		this.nome = nome;
		this.rank = rank;
		this.hp = hp;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Nome do Reploid: " + nome + "\nRank: " + rank + "\nHP: " + hp + "\nIdade: " + idade + "\n";
	}
	
	
}
