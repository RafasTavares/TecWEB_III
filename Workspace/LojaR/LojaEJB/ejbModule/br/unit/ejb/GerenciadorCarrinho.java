package br.unit.ejb;

import java.math.BigDecimal;
import java.util.Iterator;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.unit.classes.Carrinho;
import br.unit.classes.ItemPedido;
import br.unit.classes.Produto;

/**
 * Session Bean implementation class GerenciadorCarrinho
 */
@Stateless
@LocalBean
public class GerenciadorCarrinho implements GerenciadorCarrinhoLocal{

    private Carrinho carrinho = new Carrinho();
	
    public GerenciadorCarrinho() {
        
    }
    
    public GerenciadorCarrinho(Carrinho carrinho) {
    	this.carrinho = carrinho;
    }
    
    public void setCarrinho(Carrinho pCarrinho){
    	this.carrinho = pCarrinho;
    }

	@Override
	public Carrinho obterCarrinho() {
		return carrinho;
	}

	@Override
	public void InserirItem(ItemPedido itemPedido) {
		ItemPedido item = PossuiItem(itemPedido.getNumero());
		if (item != null){
			carrinho.getListaItensPedidos().remove(item);
			item.setQuantidade(itemPedido.getQuantidade());
			carrinho.getListaItensPedidos().add(item);
		}else{
			carrinho.getListaItensPedidos().add(itemPedido);
		}
	}

	@Override
	public void RemoverProdutoItem(ItemPedido item) {
		int index = carrinho.getListaItensPedidos().indexOf(item);
		item = carrinho.getListaItensPedidos().get(index);
		item.setQuantidade(item.getQuantidade() - 1);
		if (item.getQuantidade() == 0){
			carrinho.getListaItensPedidos().remove(item);
		}
	}
	
	public ItemPedido PossuiItem(int numeroItem){
		Iterator<ItemPedido> it = carrinho.getListaItensPedidos().iterator();
		ItemPedido item = null;
		while (it.hasNext()){
			item = it.next();
			if (item.getNumero() == numeroItem){
				return item;
			}
		}
		return null;
	}

	@Override
	public void InserirProduto(Produto produto) {
		ItemPedido item = PossuiProduto(produto.getCodigo());
		if (item != null){
			carrinho.getListaItensPedidos().remove(item);
			item.setQuantidade(item.getQuantidade() + 1);
			carrinho.getListaItensPedidos().add(item);
		}else{
			item = new ItemPedido(produto.getCodigo(), produto.getPreco(), 1);
			carrinho.getListaItensPedidos().add(item);
		}
	}

	public ItemPedido PossuiProduto(int cdProduto){
		Iterator<ItemPedido> it = carrinho.getListaItensPedidos().iterator();
		ItemPedido item = null;
		while (it.hasNext()){
			item = it.next();
			if (item.getCdProduto() == cdProduto){
				return item;
			}
		}
		return null;
	}
	
}
