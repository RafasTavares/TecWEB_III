package br.unit.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.unit.classes.Categoria;
import br.unit.classes.Produto;
import br.unit.classes.Subcategoria;
import br.unit.ejb.GerenciarCategoriasLocal;
import br.unit.ejb.GerenciarFrenteDeLojaLocal;

public class Index {
	
	@EJB
	private GerenciarCategoriasLocal gerenciador;
	
	private List<Categoria> categorias;
	private Categoria categoria;
	private Subcategoria subcategoria;
	private List<Subcategoria> subcategorias;
	private ExternalContext ex = FacesContext.getCurrentInstance()
			.getExternalContext();
	
	public List<Categoria> getCategorias(){
		if (categorias == null){
			categorias = gerenciador.listar();
		}
		return categorias;
	}
	
	public List<Subcategoria> getSubcategorias(){
		if(categoria == null){
			return new ArrayList<Subcategoria>();
		}else if (subcategorias == null){
			subcategorias = gerenciador.listarSubcategorias(categoria.getCodigo());
		}
		return subcategorias;
	}
	
	public void cbMenuCategoriaActionListener(ActionEvent event){
		categoria = (Categoria)ex.getRequestMap().get("categoria");
		ex.getRequestMap().put("codCategoria", categoria.getCodigo());
		subcategorias = null;
	}
	
	public void cbMenuSubcategoriaActionListener(ActionEvent event){
		int cdSubcategoria = (Integer)ex.getRequestMap().get("subcategoria");
		subcategoria = gerenciador.obterSubcategoriaPorCodigo(cdSubcategoria, categoria.getCodigo());
		ex.getRequestMap().put("codSubcategoria", subcategoria.getCodigo());
		ex.getRequestMap().put("codCategoria", subcategoria.getCdCategoria());
	}
	
}
