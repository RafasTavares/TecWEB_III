package br.unit.prova.ejb;

import br.unit.prova.jpa.PermanenciaNavio;
import br.unit.prova.jpa.PermanenciaNavioPK;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.sun.jmx.snmp.Timestamp;

/**
 * Session Bean implementation class GerenciarPermanenciaNavio
 */
@Stateless
@Local(GerenciarPermanenciaNavioLocal.class)
@LocalBean
public class GerenciarPermanenciaNavio implements GerenciarPermanenciaNavioLocal {


	@PersistenceContext
	private EntityManager em;
	
    public GerenciarPermanenciaNavio() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see GerenciarPermanenciaNavioLocal#registrarMovimento(PermanenciaNavio)
     */
    public PermanenciaNavio registrarMovimento(String pIdentificacao, String pNmComandante, String pNacionalidade, BigDecimal preco) {
    	PermanenciaNavio permanenciaNavio;
    	if (navioNoPorto(pIdentificacao)){
    		Integer proxSequencial = obterProximoSequencial(pIdentificacao);
    		permanenciaNavio = new PermanenciaNavio();
    		permanenciaNavio.setIdentificacao(pIdentificacao);
    		permanenciaNavio.setSequencial(proxSequencial);
    		permanenciaNavio.setNmComandante(pNmComandante);
    		permanenciaNavio.setNacionalidade(pNacionalidade);
    		permanenciaNavio.setDtEntrada(new Date());
    		permanenciaNavio.setDtSaida(null);
    		permanenciaNavio.setPreco(null);
    		em.persist(permanenciaNavio);
    	} else {
    		permanenciaNavio = obterPermanenciaNavio(pIdentificacao);
    		permanenciaNavio.setDtSaida(new Date());
    		permanenciaNavio.setPreco(preco);
    	}
    	return permanenciaNavio;
    }

	/**
     * @see GerenciarPermanenciaNavioLocal#obterRecibo(String, int)
     */
    public PermanenciaNavio obterDadosRecibo(String pIdentificacao, int pSequencial) {
    	PermanenciaNavio permanenciaNavio = obterPermanenciaNavio(pIdentificacao, pSequencial);
    	return permanenciaNavio;
    }

	/**
     * @see GerenciarPermanenciaNavioLocal#obterPermanenciaNavio(String)
     */
    public PermanenciaNavio obterPermanenciaNavio(String pIdentificacao) {
        Integer proxSequencial = obterProximoSequencial(pIdentificacao);
        PermanenciaNavioPK permanenciaNavioPk = new PermanenciaNavioPK();
        permanenciaNavioPk.setIdentificacao(pIdentificacao);
        permanenciaNavioPk.setSequencial(proxSequencial - 1);
		return em.find(PermanenciaNavio.class, permanenciaNavioPk);
    }
    
    public PermanenciaNavio obterPermanenciaNavio(String pIdentificacao, int pSequencial) {
        PermanenciaNavioPK permanenciaNavioPk = new PermanenciaNavioPK();
        permanenciaNavioPk.setIdentificacao(pIdentificacao);
        permanenciaNavioPk.setSequencial(pSequencial);
		return em.find(PermanenciaNavio.class, permanenciaNavioPk);
    }

    /*
     * Consulta as Permanencias dos Navios que entraram entre as datas passadas como parâmetro.
     * @see br.unit.prova.ejb.GerenciarPermanenciaNavioLocal#obterPermanencias(java.util.Date, java.util.Date)
     */
    public List<PermanenciaNavio> obterPermanencias(Date dtInicio, Date dtFim) {
    	TypedQuery<PermanenciaNavio> query = em.createNamedQuery("PermanenciaNavio.localizarEntreDatas", PermanenciaNavio.class);
    	query.setParameter("dtInicio", dtInicio);
    	query.setParameter("dtFim", dtFim);
    	List<PermanenciaNavio> resultado = query.getResultList();
		return resultado;
    }

	@Override
	public boolean navioNoPorto(String identificacao) {
		TypedQuery<PermanenciaNavio> query = em.createNamedQuery("PermanenciaNavio.localizarNavio", PermanenciaNavio.class);
		PermanenciaNavio result = query.getSingleResult();
		if (result != null){
			return true;
		}
		return false;
	}
	
	@Override
	public int obterProximoSequencial(String identificacao) {
	TypedQuery<Integer> query = em.createNamedQuery("PermanenciaNavio.obterProximoSequencial", Integer.class);
	Integer result = query.getSingleResult();
	if (result != null){
		return result;
	}
	return 1;
}

}
