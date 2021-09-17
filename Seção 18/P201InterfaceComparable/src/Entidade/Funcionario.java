package Entidade;

public class Funcionario implements Comparable <Funcionario>{
	
	private String nome;
	private Double salario;
	
	public Funcionario(String nome, Double salario) {
		super();
		this.nome = nome;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public int compareTo(Funcionario item) {
		// TODO Auto-generated method stub
		return -nome.compareTo(item.getNome());// use - para decreascente, e subttitua o get nome por get salario com salario.compare para ordenar por salario
	}
	
}
