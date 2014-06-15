package br.unit.prova.mBean;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.unit.prova.ejb.GerenciarPermanenciaNavio;
import br.unit.prova.ejb.GerenciarPermanenciaNavioLocal;
import br.unit.prova.jpa.PermanenciaNavio;

public class RegistrarMovimento {
	@EJB
	private GerenciarPermanenciaNavioLocal gerenciador;
	
	private PermanenciaNavio permanenciaNavio;
	private String msgTela; 
	
	public PermanenciaNavio getPermanenciaNavio() {
		ExternalContext ex = FacesContext.getCurrentInstance()
													.getExternalContext();
		permanenciaNavio = (PermanenciaNavio)ex.getRequestMap().get("permanenciaNavio");
		permanenciaNavio = gerenciador.registrarMovimento(permanenciaNavio.getIdentificacao(), 
									   permanenciaNavio.getNmComandante(), 
									   permanenciaNavio.getNacionalidade(), 
									   permanenciaNavio.getPreco());
		
		SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy");
		
		if (permanenciaNavio.getDtSaida() == null){
			msgTela = "Entrada do navio " + permanenciaNavio.getIdentificacao() +  " registrada em " + sdformat.format(permanenciaNavio.getDtEntrada());
		}else {
			msgTela = "Saída do navio " + permanenciaNavio.getIdentificacao() +  " registrada em " + sdformat.format(permanenciaNavio.getDtSaida());
		}
		return permanenciaNavio;
	}
	
	public String msgTela(){
		return msgTela;
	}
}
