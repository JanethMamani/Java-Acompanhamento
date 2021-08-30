import java.util.Scanner;

public class S5P39_Swith {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		String dia = null;
		
		/*
		//____________________________1 Metodo
		if (x ==1) {
			dia = "domingo";
		} else if (x == 2) {
			dia = "segunda";
		} else if (x == 3) {
			dia = "terça";
		} else if (x == 4) {
			dia = "quarta";
		} else if (x == 5) {
			dia = "quinta";
		} else if (x == 6) {
			dia = "sexta";
		} else if (x == 7) {
			dia = "sábado";
		} else {
			System.out.println("Valor inválido!");
		}
		//_____________________________1 Fim do Metodo 1
		*/
		
		
		//____________________________Começo do Metodo 2
		switch (x) {
		case 1:
			dia = "domingo";
			break;
		case 2:
			dia = "segunda";
			break;
		case 3:
			dia = "terça";
			break;
		case 4:
			dia = "quarta";
			break;
		case 5:
			dia = "quinta";
			break;
		case 6:
			dia = "sexta";
			break;
		case 7:
			dia = "sábado";
			break;
		default:
			System.out.println("Valor Inválido!");
			break;
		}
		//___________________________Fim do Metodo 2
		
		System.out.println("Dia da semana: " + dia);
	}

}
