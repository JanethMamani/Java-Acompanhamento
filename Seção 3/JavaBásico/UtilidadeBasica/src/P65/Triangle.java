package P65;
//Completar com o p64
public class Triangle {
	
	public double a;
	public double b;
	public double c;
	
	
	public double area () {
		double p = ( a + b + c ) /2.0;
		double result = Math.sqrt(p * (p - a) * (p - b) * (p - c)); //Ou return aqui diretamente
		return result;
	}

}
