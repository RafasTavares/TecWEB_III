package br.unit.prova.mBean;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.unit.prova.ejb.GerenciarPermanenciaNavio;
import br.unit.prova.ejb.GerenciarPermanenciaNavioLocal;
import br.unit.prova.jpa.PermanenciaNavio;

public class EmissaoRecibo {
	@EJB
	private GerenciarPermanenciaNavioLocal gerenciador;
	
	private PermanenciaNavio permanenciaNavio;
	private ExternalContext ex = FacesContext.getCurrentInstance()
												.getExternalContext();
	public PermanenciaNavio getPermanenciaNavio() {
		String identificacao = ex.getRequestMap().get("identificacao").toString();
		int sequencial = Integer.parseInt(ex.getRequestMap().get("sequencial").toString());
		permanenciaNavio = gerenciador.obterDadosRecibo(identificacao, sequencial);
		
		return permanenciaNavio;
	}
	
	public void cbNumerosRecibosActionListener(){
		int recibosEmitidos;
		if (ex.getSessionMap().get("nrRecibosEmitidos") != null){
			recibosEmitidos = Integer.parseInt(ex.getSessionMap().get("nrRecibosEmitidos").toString());
		}else {
			recibosEmitidos = 0;
		}
		ex.getSessionMap().put("nrRecibosEmitidos", recibosEmitidos + 1);
	}
}
