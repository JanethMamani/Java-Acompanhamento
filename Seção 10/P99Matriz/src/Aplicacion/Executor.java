package Aplicacion;

import java.util.Scanner;

public class Executor {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int[][] matriz = new int[x][x];
		
		for (int i=0;i<x;i++) {
			for (int j=0;j<x;j++) {
				matriz[i][j]= sc.nextInt();
			}
		}
		
		System.out.println("Diagonal principal: ");
		for(int i=0;i<x;i++) {
			System.out.println(matriz[i][i] + " ");
		}
		System.out.println();
		
		int count = 0;
		for(int i=0; i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
				if(matriz[i][j]<0) {
					count ++;
				}
			}
		}
		
		System.out.println("Números negativos: " + count);
		
		sc.close();
	}

}
