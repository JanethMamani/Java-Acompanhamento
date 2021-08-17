package Entidade;

public class Estudante {
	
	private String nome;
	private String email;
	private int quarto;
	
	public Estudante(String entreNome, String seuEmail, int numQuarto) {
		nome = entreNome;
		email = seuEmail;
		quarto = numQuarto;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String entreNome) {
		nome = entreNome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String seuEmail) {
		email = seuEmail;
	}
	
	public int getQuarto() {
		return quarto;
	}
	
	public void setQuarto(int newQuarto) {
		quarto = newQuarto;
	}
	
	
}
