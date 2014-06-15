package br.unit.classes;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.lang.String;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Produto
 *
 */
@Entity


@Table(catalog = "DB", schema = "PUBLIC", name = "TB_PRODUTO")
@NamedQueries({
		
	@NamedQuery(name = "Produto.obterTodos", query = "SELECT o FROM Produto o"),
	@NamedQuery(name = "Produto.obterPorCategoria", query = "SELECT o FROM Produto o WHERE o.cdCategoria = :codCategoria"),
	@NamedQuery(name = "Produto.obterPorSubcategoria", query = "SELECT o FROM Produto o WHERE o.cdSubcategoria = :codSubcategoria") 
})
public class Produto implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="CODIGO")
	private int codigo;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="PRECO")
	private BigDecimal preco;
	
	@Column(name="QUANTIDADE")
	private int quantidade;
	
	@Column(name="COD_CATEGORIA")
	private int cdCategoria;
	
	@Column(name="COD_SUBCATEGORIA")
	private int cdSubcategoria;
	private static final long serialVersionUID = 1L;

	public Produto() {
		super();
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
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String pDescricao) {
		this.descricao = pDescricao;
	}   
	public BigDecimal getPreco() {
		return this.preco;
	}

	public void setPreco(BigDecimal pPreco) {
		this.preco = pPreco;
	}   
	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int pQuantidade) {
		this.quantidade = pQuantidade;
	}   
	public int getCdCategoria() {
		return this.cdCategoria;
	}

	public void setCdCategoria(int pCdCategoria) {
		this.cdCategoria = pCdCategoria;
	}   
	public int getCdSubcategoria() {
		return this.cdSubcategoria;
	}

	public void setCdSubcategoria(int pCdSubcategoria) {
		this.cdSubcategoria = pCdSubcategoria;
	}
   
}
