package br.unit.prova.mBean;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import br.unit.prova.ejb.GerenciarPermanenciaNavio;
import br.unit.prova.ejb.GerenciarPermanenciaNavioLocal;
import br.unit.prova.jpa.PermanenciaNavio;

public class ListarPermanencias {
	
	@EJB
	private GerenciarPermanenciaNavioLocal gerenciador;
	
	private Date dtInicio;
	private Date dtFim;
	
	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	private List<PermanenciaNavio> listaPermanenciaNavio;

	public List<PermanenciaNavio> getListaPermanenciaNavio() {
		listaPermanenciaNavio = gerenciador.obterPermanencias(dtInicio, dtFim);
		return listaPermanenciaNavio;
	}
}
