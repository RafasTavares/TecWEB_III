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

public class Subcategorias {
	
	private List<Subcategoria> subcategorias;
	private Categoria categoria;
	private ExternalContext ex = FacesContext.getCurrentInstance().getExternalContext();
	private int codigoCategoria;

	@EJB
	private GerenciarCategoriasLocal gerenciador;
	
	public List<Subcategoria> getSubcategorias(){
		if ((Integer)ex.getRequestMap().get("codigoCategoria") != null){
			codigoCategoria = (Integer)ex.getRequestMap().get("codigoCategoria");
			subcategorias = gerenciador.listarSubcategorias(codigoCategoria);
		}else{
			subcategorias = new ArrayList<Subcategoria>();
		}
		return subcategorias;
	}

	public Categoria getCategoria(){
		
		return gerenciador.obterCategoriaPorCodigo(codigoCategoria);
		
	}
	
	public void cbNovaSubcategoriaActionListener(ActionEvent event){
		
	}
	
	public void cbEditarActionListener(ActionEvent event) {
		Subcategoria subcategoria = (Subcategoria) ex.getRequestMap().get("subcategoria");
		ex.getRequestMap().put("codigoSubcategoria", subcategoria.getCodigo());
	}	

	public void cbExcluirActionListener(ActionEvent event) {
		Subcategoria subcategoria = (Subcategoria) ex.getRequestMap().get("subcategoria");
		gerenciador.removerSubcategoria(subcategoria);
	}
	
	public int getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}
}
