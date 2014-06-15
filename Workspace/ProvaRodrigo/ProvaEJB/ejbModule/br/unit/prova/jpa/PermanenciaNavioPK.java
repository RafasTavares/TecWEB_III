package br.unit.prova.jpa;

import java.io.Serializable;
import java.lang.Integer;

/**
 * ID class for entity: PermanenciaNavio
 *
 */ 
public class PermanenciaNavioPK  implements Serializable {   
   
	private String identificacao;

	private Integer sequencial;
	private static final long serialVersionUID = 1L;

	public PermanenciaNavioPK() {}

	

	public Integer getSequencial() {
		return this.sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof PermanenciaNavioPK)) {
			return false;
		}
		PermanenciaNavioPK other = (PermanenciaNavioPK) o;
		return true
			&& (getSequencial() == null ? other.getSequencial() == null : getSequencial().equals(other.getSequencial()))
			&& (getIdentificacao() == null ? other.getIdentificacao() == null : getIdentificacao().equals(other.getIdentificacao()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getSequencial() == null ? 0 : getSequencial().hashCode());
		result = prime * result + (getIdentificacao() == null ? 0 : getIdentificacao().hashCode());
		return result;
	}
   
   
}
