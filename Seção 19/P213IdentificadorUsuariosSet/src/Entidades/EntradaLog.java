package Entidades;

import java.util.Date;
import java.util.Objects;

public class EntradaLog {
	
	private String username;
	private Date entrada;
	
	public EntradaLog(String nome, Date momento) {
		username = nome;
		entrada = momento;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntradaLog other = (EntradaLog) obj;
		return Objects.equals(username, other.username);
	}
	
	
}
