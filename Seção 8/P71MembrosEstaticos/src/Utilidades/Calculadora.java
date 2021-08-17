package Utilidades;

public class Calculadora {

	//Por conveniencia padrao as constantes final e declaradas sao capitalizadas e separadas por _
	public static final double ESSE_E_O_PI = 3.14159; 
	
	public static double circunf (double medida) {
		return 2.0 * ESSE_E_O_PI * medida;
	}
	
	public static double volume (double medida) {
		return 4.0 * ESSE_E_O_PI * medida * medida * medida /3.0;
	}
	
}
