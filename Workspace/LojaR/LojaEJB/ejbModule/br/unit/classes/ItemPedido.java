package br.unit.classes;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ItemPedido
 *
 */
@Entity

@IdClass(ItemPedidoPK.class)
@Table(catalog = "DB", schema = "PUBLIC", name = "TB_ITEMPEDIDO")
@NamedQuery(name = "ItemPedido.obterTodos", query = "SELECT o FROM ItemPedido o WHERE o.numero = :numero")
public class ItemPedido implements Serializable {

	   
	@Id
	@Column(name = "NUMERO")
	private int numero;
	@Id
	@Column(name = "SEQUENCIA")
	private int sequencia;
	@Column(name = "COD_PRODUTO")
	private int cdProduto;
	@Column(name = "PRECO_UNITARIO")
	private BigDecimal precoUnitario;
	@Column(name = "QUANTIDADE")
	private int quantidade;
	private static final long serialVersionUID = 1L;

	public ItemPedido() {
		super();
	}
	
	public ItemPedido(int pCdProduto, BigDecimal pPrecoUnitario, int pQuantidade) {
		super();
		cdProduto = pCdProduto;
		precoUnitario = pPrecoUnitario;
		quantidade = pQuantidade;
	}
	
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
	public int getCdProduto() {
		return this.cdProduto;
	}

	public void setCdProduto(int cdProduto) {
		this.cdProduto = cdProduto;
	}   
	public BigDecimal getPrecoUnitario() {
		return this.precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}   
	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
   
}
