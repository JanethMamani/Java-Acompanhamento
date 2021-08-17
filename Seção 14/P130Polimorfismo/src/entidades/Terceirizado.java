package entidades;

public class Terceirizado extends Funcionario {
	
	private Double gastoAdicional;
	
	public Terceirizado() {
		super();
	}

	public Terceirizado(String nome, Integer horas, Double valorHora, Double gastoAdicional) {
		super(nome, horas, valorHora);
		this.gastoAdicional = gastoAdicional;
	}

	public Double getGastoAdicional() {
		return gastoAdicional;
	}

	public void setGastoAdicional(Double gastoAdicional) {
		this.gastoAdicional = gastoAdicional;
	}
	
	@Override
	public double pagamento() {
		return super.pagamento() + 1.1*gastoAdicional;
	}

}
