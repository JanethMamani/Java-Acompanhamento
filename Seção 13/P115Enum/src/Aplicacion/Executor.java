package Aplicacion;

import java.util.Date;

import Entidade.Pedido;
import Entidades.enums.OrderStatus;

public class Executor {
	
	public static void main(String[] args) {
		
		Pedido itemQualquer = new Pedido(1080, new Date(), OrderStatus.Pagamento_Pendente);
		
		System.out.println(itemQualquer);
		
		
		OrderStatus entregue1 = OrderStatus.Entregue;
		OrderStatus entregue2 = OrderStatus.valueOf("Entregue");
		System.out.println(entregue1);
		System.out.println(entregue2);
	}

}
