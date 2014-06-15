package br.unit.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.unit.classes.Categoria;
import br.unit.ejb.GerenciarCategoriasLocal;

public class Categorias {
	private List<Categoria> categorias;
	
	private ExternalContext ex = FacesContext.getCurrentInstance()
			.getExternalContext();
	
	@EJB
	private GerenciarCategoriasLocal gerenciador;

	public List<Categoria> getCategorias() {
		categorias = gerenciador.listar();
		if (categorias == null) {
			return new ArrayList<Categoria>();
		}
		return categorias;
	}

	public void cbEditarActionListener(ActionEvent event) {
		Categoria categoria = (Categoria) ex.getRequestMap().get("categoria");
		ex.getRequestMap().put("codigoCategoria", categoria.getCodigo());
	}

	public void cbExcluirActionListener(ActionEvent event) {
		Categoria categoria = (Categoria) ex.getRequestMap().get("categoria");
		gerenciador.removerCategoria(categoria.getCodigo());
	}
	
	public void cdSubcategoriasActionListener(ActionEvent event){
		Categoria categoria = (Categoria)ex.getRequestMap().get("categoria");
		ex.getRequestMap().put("codigoCategoria", categoria.getCodigo());
	}
}
