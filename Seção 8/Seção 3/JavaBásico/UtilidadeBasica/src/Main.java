import java.util.Locale;

public class Main {
	
	public static void main(String[] args) {
		int y = 30;
		double x = 5.9876;
		System.out.print("Ol? mundo!");
		System.out.println("Bom dia!");
		System.out.println(y);
		System.out.printf("%.2f%n", x);
		System.out.print("Listo!");
		Locale.setDefault(Locale.US);
	}

}
