package br.unit.ejb;

import javax.ejb.Local;

import br.unit.classes.Carrinho;
import br.unit.classes.ItemPedido;
import br.unit.classes.Produto;

@Local
public interface GerenciadorCarrinhoLocal {
	
	public Carrinho obterCarrinho();
	public void InserirItem(ItemPedido itemPedido);
	public void RemoverProdutoItem(ItemPedido item);
	public void InserirProduto(Produto produto);
}
