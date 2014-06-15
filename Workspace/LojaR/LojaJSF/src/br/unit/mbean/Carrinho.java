package br.unit.mbean;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.unit.classes.ItemPedido;
import br.unit.classes.Pedido;
import br.unit.classes.Produto;
import br.unit.ejb.GerenciadorCarrinho;
import br.unit.ejb.GerenciarFrenteDeLojaLocal;

public class Carrinho {
	@EJB
	private GerenciarFrenteDeLojaLocal gerenciador;
	
	private GerenciadorCarrinho gerenciadorCarrinho;
	
	private br.unit.classes.Carrinho carrinho;
	private List<Pedido> pedido;
	private List<ItemPedido> itensPedidos;
	private BigDecimal valorTotal;
	private String nomeProduto;
	
	private ExternalContext ex = FacesContext.getCurrentInstance()
			.getExternalContext();
	
	public Produto obterProduto(int cdProduto){
		Produto produto = gerenciador.obterProduto(cdProduto);
		return produto;
	}
	
	public List<Pedido> getPedido() {
		return pedido;
	}
	
	public List<ItemPedido> getItensPedidos() {
		itensPedidos = carrinho.getListaItensPedidos();
		return itensPedidos;
	}
	
	public br.unit.classes.Carrinho getCarrinho(){
		carrinho = (br.unit.classes.Carrinho)ex.getSessionMap().get("carrinho");
		gerenciadorCarrinho = new GerenciadorCarrinho(carrinho);
		return carrinho;
	}
	
	public BigDecimal getValorTotal(){
		valorTotal = gerenciadorCarrinho.obterCarrinho().valorTotal();
		return valorTotal;
	}
	
	public String getNomeProduto(int codigoProduto){
		return gerenciador.obterProduto(codigoProduto).getNome();
	}
}
