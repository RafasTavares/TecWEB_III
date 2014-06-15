package br.unit.classes;

import java.io.Serializable;
import java.lang.Integer;

/**
 * ID class for entity: Subcategoria
 *
 */ 
public class SubcategoriaPK  implements Serializable {   
   
	private Integer codigo;         
	private Integer cdCategoria;
	private static final long serialVersionUID = 1L;

	public SubcategoriaPK() {}

	

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer pCodigo) {
		this.codigo = pCodigo;
	}
	

	public Integer getCdCategoria() {
		return this.cdCategoria;
	}

	public void setCdCategoria(Integer pCdCategoria) {
		this.cdCategoria = pCdCategoria;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof SubcategoriaPK)) {
			return false;
		}
		SubcategoriaPK other = (SubcategoriaPK) o;
		return true
			&& (getCodigo() == null ? other.getCodigo() == null : getCodigo().equals(other.getCodigo()))
			&& (getCdCategoria() == null ? other.getCdCategoria() == null : getCdCategoria().equals(other.getCdCategoria()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getCodigo() == null ? 0 : getCodigo().hashCode());
		result = prime * result + (getCdCategoria() == null ? 0 : getCdCategoria().hashCode());
		return result;
	}
   
   
}
