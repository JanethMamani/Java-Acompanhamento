package Integrantes;

public class Hunter {
	
	private String nome;
	private String rank;
	private Double HP;
	
	public Hunter(String nome, String rank, Double hP) {
		super();
		this.nome = nome;
		this.rank = rank;
		HP = hP;
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

	public Double getHP() {
		return HP;
	}

	public void setHP(Double hP) {
		HP = hP;
	}
	


	@Override
	public String toString() {
		return "Hunter: " + nome + "\nRank: " + rank + "; \nHP = " + HP;
	}
	
	
}
