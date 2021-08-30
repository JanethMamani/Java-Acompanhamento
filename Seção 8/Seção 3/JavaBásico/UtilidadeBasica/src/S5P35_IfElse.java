import java.util.Scanner;

public class S5P35_IfElse {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int hora;
		
		System.out.println("Quantas horas?");
		hora = sc.nextInt();
		
		if (hora <12) {
			System.out.println("Bom dia!");
		}
		else {   // Reduza e tenha seu famoso else if
			if (hora < 18) {
				System.out.println("Boa tarde!");
			}
			else {
				System.out.println("Boa noite!");
			}
			
		}
		sc.close();
	}

}
