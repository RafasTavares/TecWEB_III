package br.unit.prova.jpa;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PermanenciaNavio
 *
 */
@Entity
@IdClass(PermanenciaNavioPK.class)
@Table(catalog = "DB", schema = "PUBLIC", name = "TB_PERMANENCIA_NAVIO")
@NamedQueries({
	@NamedQuery(name = "PermanenciaNavio.localizarNavio", query = "SELECT o FROM PermanenciaNavio o WHERE o.identificacao = :identificacao and o.dtSaida = null"),
	@NamedQuery(name = "PermanenciaNavio.localizarEntreDatas", query = "SELECT o FROM PermanenciaNavio o WHERE o.dtEntrada >= :dtInicio and o.dtEntrada <= :dtFim"),
	@NamedQuery(name = "PermanenciaNavio.obterProximoSequencial", query = "SELECT MAX(o.sequencial) FROM PermanenciaNavio o WHERE o.identificacao = :identificacao") 
})
public class PermanenciaNavio implements Serializable {
	
	@Id
	@Column(name = "IDENTIFICACAO")
	private String identificacao;   
	@Id
	@Column(name = "SEQUENCIA")
	private Integer sequencial;
	@Column(name = "DT_ENTRADA")
	private Date dtEntrada;
	@Column(name = "DT_SAIDA")
	private Date dtSaida;
	@Column(name = "NM_COMANDANTE")
	private String nmComandante;
	@Column(name = "NACIONALIDADE")
	private String nacionalidade;
	@Column(name = "PRECO")
	private BigDecimal preco;
	@Column(name = "ST_RECIBO")
	private Boolean reciboRecebido;
	private static final long serialVersionUID = 1L;

	public PermanenciaNavio() {
		super();
	}
	public String getIdentificacao() {
		return this.identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}   
	public Integer getSequencial() {
		return this.sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}   
	public Date getDtEntrada() {
		return this.dtEntrada;
	}

	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}   
	public Date getDtSaida() {
		return this.dtSaida;
	}

	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}   
	public String getNmComandante() {
		return this.nmComandante;
	}

	public void setNmComandante(String nmComandante) {
		this.nmComandante = nmComandante;
	}   
	public String getNacionalidade() {
		return this.nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}   
	public BigDecimal getPreco() {
		return this.preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}   
	public Boolean getReciboRecebido() {
		return this.reciboRecebido;
	}

	public void setReciboRecebido(Boolean reciboRecebido) {
		this.reciboRecebido = reciboRecebido;
	}

}
