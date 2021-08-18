package Aplicacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class Programa {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat entradaData = new SimpleDateFormat("dd/mm/yyyy");
		
		List<Produto> produtos = new ArrayList<>();
		
		System.out.print("Entre com o numero de produtos: ");
		int quant = sc.nextInt();
		
		for(int i=1; i<=quant; i++) {
			System.out.println("Dados do produto #" + i + ":");
			System.out.print("Comum, usado ou importado (c/u/i)?");
			char opcao = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			Double preco = sc.nextDouble();
			if (opcao == 'u') {
				System.out.print("Data de fabricação: ");
				String dataFabrica = sc.next();
				Date dataFabricacao = entradaData.parse(dataFabrica);
				
				produtos.add(new ProdutoUsado(nome,preco,dataFabricacao));
			} else if (opcao == 'i') {
				System.out.print("Preço da alfandega: ");
				Double precoAlfa = sc.nextDouble();
				
				produtos.add(new ProdutoImportado(nome, preco, precoAlfa));
			} else {
				produtos.add(new Produto(nome, preco));
			}
		}
		System.out.println();
		System.out.println("Etiquetas de Preços: ");
		
		for(Produto item:produtos) {
			System.out.print(item.getNome() + " $ " + String.format("%.2f", item.getPreco()));
			if(item instanceof ProdutoUsado) {
				ProdutoUsado item1 = (ProdutoUsado)item;
				System.out.println(" (Data de Fabricação: " + item1.getDataFabricacao() + ")");
			}else if(item instanceof ProdutoImportado){
				ProdutoImportado item2 = (ProdutoImportado)item;
				System.out.println(" (Custo da alfandega: " + item2.getPrecoAlfandega() + ")");
			} else {
				System.out.println();
			}
		}
	}
}
