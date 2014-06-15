package br.unit.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.unit.classes.Categoria;
import br.unit.classes.Subcategoria;
import br.unit.ejb.GerenciarCategoriasLocal;

public class Template {
	
	@EJB
	private GerenciarCategoriasLocal gerenciador;
	
	private List<Categoria> categorias;
	private Categoria categoria;
	private List<Subcategoria> subcategorias;
	private ExternalContext ex = FacesContext.getCurrentInstance()
			.getExternalContext();
	
	public List<Categoria> getCategorias(){
		categorias = gerenciador.listar();
		return categorias;
	}
	
	public List<Subcategoria> getSubcategorias(){
		if(categoria == null){
			return new ArrayList<Subcategoria>();
		}
		subcategorias = gerenciador.listarSubcategorias(categoria.getCodigo());
		return subcategorias;
	}
	
	public void cbMenuCategoriaActionListener(ActionEvent event){
		int codCategoria = Integer.parseInt(ex.getRequestMap().get("codCategoria").toString());
		categoria = gerenciador.obterCategoriaPorCodigo(codCategoria);
	}
}
