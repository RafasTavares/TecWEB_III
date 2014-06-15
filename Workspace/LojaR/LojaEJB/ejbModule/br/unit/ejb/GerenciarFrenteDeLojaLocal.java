package br.unit.ejb;

import java.util.List;

import javax.ejb.Local;

import br.unit.classes.*;

@Local
public interface GerenciarFrenteDeLojaLocal {

	public List<Produto> listarProdutos();
	public List<Produto> listarProdutosPorCategoria(int codCategoria);
	public List<Produto> listarProdutosPorSubcategoria(int codSubcategoria);
	public Produto obterProduto(int cdProduto);
	public void inserirProduto(Produto produto);
	public void removerProduto(Produto produto);
	public void alterarNomeProduto(Produto produto);
	public int obterProximoCodProduto(int cdProduto);
	
	public List<Pedido> listarPedidos(int cdCliente);
	public List<ItemPedido> obterItensPedidos(int numero);
	
	public Cliente obterCliente(int cdCliente);
	public void incluirCliente(Cliente cliente);
	public boolean autenticar(Cliente cliente);
}
