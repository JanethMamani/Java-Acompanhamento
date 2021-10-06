package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Vendedor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String email;
	private Date nascimento;
	private Double salarioBase;
	
	private Departamento departamentoDoVendedor;

	public Vendedor(Integer id, String nome, String email, Date nascimento, Double salarioBase,
			Departamento departamentoDoVendedor) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
		this.salarioBase = salarioBase;
		this.departamentoDoVendedor = departamentoDoVendedor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamentoDoVendedor() {
		return departamentoDoVendedor;
	}

	public void setDepartamentoDoVendedor(Departamento departamentoDoVendedor) {
		this.departamentoDoVendedor = departamentoDoVendedor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", nome=" + nome + ", email=" + email + ", nascimento=" + nascimento
				+ ", salarioBase=" + salarioBase + ", departamentoDoVendedor=" + departamentoDoVendedor + "]";
	}
	
}
