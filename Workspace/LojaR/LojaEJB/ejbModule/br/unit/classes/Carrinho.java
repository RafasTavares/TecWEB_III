package br.unit.classes;

import java.math.BigDecimal;
import java.util.List;

public class Carrinho {

	private List<ItemPedido> listaItensPedidos;

	public List<ItemPedido> getListaItensPedidos() {
		return listaItensPedidos;
	}

	public void setListaItensPedidos(List<ItemPedido> listaItensPedidos) {
		this.listaItensPedidos = listaItensPedidos;
	}
	
	public BigDecimal valorTotal(){
		BigDecimal valorTotal = new BigDecimal(0);
		for (ItemPedido item : listaItensPedidos) {
			valorTotal.add(item.getPrecoUnitario());
		}
		return valorTotal;
	}
}
