package com.marcosweb.mywebproject.entities.pk;

import java.io.Serializable;

import com.marcosweb.mywebproject.entities.Order;
import com.marcosweb.mywebproject.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//classe auxiliar de OrderItem, criada pois não há annotations de chave primária composta no JPA
//esta classe NÃO se tornará uma tabela, ela existe pois o JPA exige uma classe auxiliar para que, então, a classe OrderItem se torne uma tabela com chave primária composta.
//as chaves primárias associarão as tabelas Products e Order (guarda informações adicionais que não pertencem às duas, mas que estão associadas a elas)
//@Embeddable indicação de classe auxiliar que será interpretada como uma chave composta de outra classe que é quem a acessa (OrderItem)
@Embeddable
public class OrderItemPK implements Serializable {
	private static final long serialVersionUID = 1L;

	//será chave primária da tabela OrderItem
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	//será chave primária da tabela OrderItem
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
}