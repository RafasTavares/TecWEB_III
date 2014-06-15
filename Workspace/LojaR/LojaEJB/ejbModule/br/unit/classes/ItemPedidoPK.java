package br.unit.classes;

import java.io.Serializable;

/**
 * ID class for entity: ItemPedido
 *
 */ 
public class ItemPedidoPK  implements Serializable {   
   
	
	private int numero;         
	private int sequencia;
	private static final long serialVersionUID = 1L;

	public ItemPedidoPK() {}

	

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	

	public int getSequencia() {
		return this.sequencia;
	}

	public void setSequencia(int sequencia) {
		this.sequencia = sequencia;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ItemPedidoPK)) {
			return false;
		}
		ItemPedidoPK other = (ItemPedidoPK) o;
		return true
			&& getNumero() == other.getNumero()
			&& getSequencia() == other.getSequencia();
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getNumero();
		result = prime * result + getSequencia();
		return result;
	}
   
   
}
