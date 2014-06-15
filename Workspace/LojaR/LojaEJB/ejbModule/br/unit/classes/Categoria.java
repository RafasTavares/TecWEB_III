package br.unit.classes;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity implementation class for Entity: Categoria
 *
 */
@Entity

@Table(catalog = "DB", schema = "PUBLIC", name = "TB_CATEGORIA")
@NamedQuery(name = "Categoria.obterTodos", query = "SELECT o FROM Categoria o")
public class Categoria implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="CODIGO")
	private int codigo;
	@Column(name="NOME")
	private String nome;
	private static final long serialVersionUID = 1L;

	public Categoria() {
		super();
	}   
	
	public Categoria(int pCodigo, String pNome) {
		codigo = pCodigo;
		nome = pNome;
	}   
	
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int pCodigo) {
		this.codigo = pCodigo;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String pNome) {
		this.nome = pNome;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Categoria){
			Categoria categoria = (Categoria)obj;
			if (this.codigo == categoria.getCodigo()){
				return true;
			}
			return false;
		}
		return false;
	}
   
}
