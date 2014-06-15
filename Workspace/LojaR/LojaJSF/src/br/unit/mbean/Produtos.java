package br.unit.mbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.unit.classes.Categoria;
import br.unit.classes.Produto;
import br.unit.ejb.GerenciarFrenteDeLojaLocal;

public class Produtos {

	@EJB
	private GerenciarFrenteDeLojaLocal gerenciador;
	
	private List<Produto> produtos;
	private ExternalContext ex = FacesContext.getCurrentInstance()
			.getExternalContext();
	
	public List<Produto> getProdutos(){
		if (ex.getRequestMap().get("codCategoria") != null){
			if (ex.getRequestMap().get("codSubcategoria") != null){
				int codSubcategoria = Integer.parseInt(ex.getRequestMap().get("codSubcategoria").toString());
				produtos = gerenciador.listarProdutosPorSubcategoria(codSubcategoria);
			} else {
				int codCategoria = Integer.parseInt(ex.getRequestMap().get("codCategoria").toString());
				produtos = gerenciador.listarProdutosPorCategoria(codCategoria);
			}
		} else {
			produtos = gerenciador.listarProdutos();
		}
		return produtos;
	}
	
	public void cbDetalhesProdutoActionListener(ActionEvent event){
		Produto produto = (Produto)ex.getRequestMap().get("produto");
		ex.getRequestMap().put("codigoProduto", produto.getCodigo());
	}
}
