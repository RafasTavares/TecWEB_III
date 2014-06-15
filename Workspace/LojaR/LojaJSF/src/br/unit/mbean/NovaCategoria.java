package br.unit.mbean;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;

import br.unit.classes.Categoria;
import br.unit.ejb.GerenciarCategorias;

public class NovaCategoria {

	private Categoria categoria;
	private int codigoEditando;
	private ExternalContext ex = FacesContext.getCurrentInstance()
			.getExternalContext();
	@EJB
	private GerenciarCategorias gerenciador;

	public Categoria getCategoria() {
		if (ex.getRequestMap()
				.get("codigoCategoria") != null){
			codigoEditando = (Integer)ex.getRequestMap()
											.get("codigoCategoria");
			
			categoria = gerenciador.obterCategoriaPorCodigo(codigoEditando);
		}else if (categoria == null) {
			categoria = new Categoria();
		}
		return categoria;
	}

	public void cbSalvarActionListener(ActionEvent event) throws IOException {
		if (categoria.getCodigo() == 0) {
			categoria.setCodigo(codigoEditando);
			gerenciador.inserirCategoria(categoria);
		}else {
			gerenciador.alterarNomeCategoria(categoria.getCodigo(), categoria.getNome());
		}
	}
}
