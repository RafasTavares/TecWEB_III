package br.unit.classes;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.TABLE;
import static javax.persistence.GenerationType.AUTO;

/**
 * Entity implementation class for Entity: Subcategoria
 *
 */
@Entity

@IdClass(SubcategoriaPK.class)
@Table(catalog = "DB", schema = "PUBLIC", name = "TB_SUBCATEGORIA")
@NamedQueries({
		
	@NamedQuery(name = "Subcategoria.obterSubcategorias", query = "SELECT o FROM Subcategoria o WHERE o.cdCategoria = :codigoCategoria"),
		
	@NamedQuery(name = "Subcategoria.obterProximoCodigoSubcategoria", query = "SELECT MAX(o.codigo) FROM Subcategoria o WHERE o.cdCategoria = :codigoCategoria") 
})
public class Subcategoria implements Serializable {

	   
	@Id
	@Column(name="CODIGO_SUB")
	private Integer codigo;   
	@Id
	@Column(name="CODIGO_CATEGORIA")
	private Integer cdCategoria;
	@Column(name="NOME")
	private String nome;
	private static final long serialVersionUID = 1L;

	public Subcategoria() {
		super();
	}   
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
		this.cdCategoria= pCdCategoria;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String pNome) {
		this.nome = pNome;
	}
   
}
