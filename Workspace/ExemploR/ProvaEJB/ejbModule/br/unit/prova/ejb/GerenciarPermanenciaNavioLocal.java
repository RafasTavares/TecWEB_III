package br.unit.prova.ejb;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import br.unit.prova.jpa.PermanenciaNavio;

@Local
public interface GerenciarPermanenciaNavioLocal {
	
	public PermanenciaNavio obterPermanenciaNavio(String pIdentificacao);
	public PermanenciaNavio obterPermanenciaNavio(String pIdentificacao, int pSequencial);
	public PermanenciaNavio obterDadosRecibo(String pIdentificacao, int pSequencial);
	public List<PermanenciaNavio> obterPermanencias(Date dtInicio, Date dtFim);
	public PermanenciaNavio registrarMovimento(String pIdentificacao, String pNmComandante, String pNacionalidade, BigDecimal preco);
	public boolean navioNoPorto(String identificacao);
	public int obterProximoSequencial(String identificacao);
}
