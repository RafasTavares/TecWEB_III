package br.unit.mbean;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.unit.classes.Categoria;
import br.unit.classes.Subcategoria;
import br.unit.ejb.GerenciarCategorias;

public class NovaSubcategoria {
	
	private Subcategoria subcategoria;
	private Integer codigoCategoria;
	private int codigoEditando;
	private ExternalContext ex = FacesContext.getCurrentInstance()
			.getExternalContext();
	@EJB
	private GerenciarCategorias gerenciador;

	public Subcategoria getSubcategoria(){
		if (ex.getRequestMap()
				.get("codigoSubcategoria") != null){
			
			codigoEditando = (Integer)ex.getRequestMap()
					.get("codigoSubcategoria");
			
			subcategoria = gerenciador.obterSubcategoriaPorCodigo(codigoEditando, codigoCategoria);
			
			ex.getRequestMap().remove("codigoSubcategoria");
			
		}else if (subcategoria == null) {
			subcategoria = new Subcategoria();
		}
		return subcategoria;
	}

	public Integer getCodigoCategoria() {
		if (codigoCategoria == null){
			codigoCategoria = (Integer)ex.getRequestMap().get("codigoCategoria");
		}
		if (codigoCategoria == null){
			String numCod = ex.getRequestParameterMap().get("codCategoria");
			codigoCategoria = Integer.parseInt(numCod);
		}
		return codigoCategoria;
	}

	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public void cbSalvarActionListener(ActionEvent event) throws IOException {
		getCodigoCategoria();
		subcategoria.setCdCategoria(codigoCategoria);
		if (subcategoria.getCodigo() == 0) {
			gerenciador.inserirSubcategoria(subcategoria);
		}else {
			gerenciador.alterarNomeSubcategoria(subcategoria);
		}
	}	
}
