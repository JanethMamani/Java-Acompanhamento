package Entidade;

import java.util.Date;

import Entidades.enums.OrderStatus;

public class Pedido {
	
	private Integer id;
	private Date momento;
	private OrderStatus estado;
	
	public Pedido(Integer nid, Date oMomento, OrderStatus estadoPedido){
		id = nid;
		momento = oMomento;
		estado = estadoPedido;
	}
	
	public void setId(Integer enterId) {
		id = enterId;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setMomento(Date enterMomento) {
		momento = enterMomento;
	}
	
	public Date getMomento() {
		return momento;
	}
	
	public void setStatus(OrderStatus enterStatus) {
		estado = enterStatus;
	}
	
	public OrderStatus getStatus() {
		return estado;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", momento=" + momento + ", estado=" + estado + "]";
	}
	
	

}
