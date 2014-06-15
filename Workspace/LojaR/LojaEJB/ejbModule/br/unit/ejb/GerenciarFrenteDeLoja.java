package br.unit.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.unit.classes.Categoria;
import br.unit.classes.Cliente;
import br.unit.classes.ItemPedido;
import br.unit.classes.Pedido;
import br.unit.classes.Produto;

@Stateless
@Local(GerenciarFrenteDeLojaLocal.class)
@LocalBean
public class GerenciarFrenteDeLoja implements GerenciarFrenteDeLojaLocal{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Produto> listarProdutosPorCategoria(int codCategoria) {
		TypedQuery<Produto> query = em.createNamedQuery("Produto.obterPorCategoria", Produto.class);
		query.setParameter("codCategoria", codCategoria);
        return query.getResultList();
	}
	
	@Override
	public List<Produto> listarProdutosPorSubcategoria(int codSubcategoria) {
		TypedQuery<Produto> query = em.createNamedQuery("Produto.obterPorSubcategoria", Produto.class);
		query.setParameter("codSubcategoria", codSubcategoria);
        return query.getResultList();
	}
	
	@Override
	public List<Produto> listarProdutos() {
		TypedQuery<Produto> query = em.createNamedQuery("Produto.obterTodos", Produto.class);
        return query.getResultList();
	}

	@Override
	public Produto obterProduto(int cdProduto) {
		return em.find(Produto.class, cdProduto);
	}

	@Override
	public void inserirProduto(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerProduto(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarNomeProduto(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int obterProximoCodProduto(int cdProduto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Pedido> listarPedidos(int cdCliente) {
		TypedQuery<Pedido> query = em.createNamedQuery("Pedido.obterTodos", Pedido.class);
		query.setParameter("cdCliente", cdCliente);
        return query.getResultList();
	}

	@Override
	public List<ItemPedido> obterItensPedidos(int numero) {
		TypedQuery<ItemPedido> query = em.createNamedQuery("Pedido.obterTodos", ItemPedido.class);
		query.setParameter("numero", numero);
        return query.getResultList();
	}

	@Override
	public Cliente obterCliente(int cdCliente) {
		return em.find(Cliente.class, cdCliente);
	}

	@Override
	public void incluirCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean autenticar(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
