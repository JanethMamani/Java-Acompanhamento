import java.util.Scanner;

public class S4P26_Entrada {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double x;
		x = sc.nextDouble();
		System.out.println("Você digitou: " + x);
		
		
		char a;
		a = sc.next().charAt(0);
		System.out.println(a);
		
		sc.close();
	}

}
