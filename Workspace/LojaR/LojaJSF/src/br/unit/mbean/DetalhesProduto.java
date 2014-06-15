package br.unit.mbean;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.unit.classes.Produto;
import br.unit.ejb.GerenciadorCarrinho;
import br.unit.ejb.GerenciarFrenteDeLojaLocal;

public class DetalhesProduto {

	@EJB
	private GerenciarFrenteDeLojaLocal gerenciador;
	
	private GerenciadorCarrinho gerenciadorCarrinho;
	
	private Produto produto;
	private br.unit.classes.Carrinho carrinho;
	
	private ExternalContext ex = FacesContext.getCurrentInstance()
			.getExternalContext();
	
	public Produto getProduto() {
		if (ex.getRequestMap()
				.get("codigoProduto") != null){
			int cdProduto = Integer.parseInt(ex.getRequestMap().get("codigoProduto").toString());
			produto = gerenciador.obterProduto(cdProduto);
		}
		return produto;
	}
	
	public void cbAddCarrinhoActionListener(ActionEvent event){
		int codigoProduto = Integer.parseInt(ex.getRequestMap().get("cdProduto").toString());
		carrinho = (br.unit.classes.Carrinho)ex.getSessionMap().get("carrinho");
		gerenciadorCarrinho = new GerenciadorCarrinho(carrinho);
		gerenciadorCarrinho.InserirProduto(produto);
		ex.getSessionMap().put("carrinho", gerenciadorCarrinho.obterCarrinho());
		try {
			ex.redirect("carrinho.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cbVoltarActionListener(ActionEvent event){
		ex.getRequestMap().remove("codigoProduto");
	}
}
