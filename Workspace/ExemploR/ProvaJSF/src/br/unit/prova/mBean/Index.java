package br.unit.prova.mBean;

import java.math.BigDecimal;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.unit.prova.ejb.GerenciarPermanenciaNavio;
import br.unit.prova.ejb.GerenciarPermanenciaNavioLocal;
import br.unit.prova.jpa.PermanenciaNavio;

public class Index {
	
	private ExternalContext ex = FacesContext.getCurrentInstance()
	.getExternalContext();
	private int recibosEmitidos;
	
	@EJB
	private GerenciarPermanenciaNavioLocal gerenciador;
	
	public int getRecibosEmitidos() {
		if (ex.getSessionMap().get("nrRecibosEmitidos") != null){
			recibosEmitidos = Integer.parseInt(ex.getSessionMap().get("nrRecibosEmitidos").toString());
		}else {
			recibosEmitidos = 0;
		}
		return recibosEmitidos;
	}

	public void cbRegistrarMovimentoActionListener(ActionEvent event){
		String identificacao = ex.getRequestMap().get("identificacao").toString();
		String nmComandante = ex.getRequestMap().get("nmComandante").toString();
		String nacionalidade = ex.getRequestMap().get("nacionalidade").toString();
		BigDecimal preco = new BigDecimal(ex.getRequestMap().get("preco").toString());
		PermanenciaNavio permanenciaNavio = new PermanenciaNavio();
		permanenciaNavio = new PermanenciaNavio();
		permanenciaNavio.setIdentificacao(identificacao);
		permanenciaNavio.setNmComandante(nmComandante);
		permanenciaNavio.setNacionalidade(nacionalidade);
		permanenciaNavio.setPreco(preco);
		ex.getRequestMap().put("permanenciaNavio", permanenciaNavio);
	}
	
}
