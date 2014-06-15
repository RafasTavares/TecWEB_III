package br.unit.classes;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.lang.Character;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pedido
 *
 */
@Entity


@Table(catalog = "DB", schema = "PUBLIC", name = "TB_PEDIDO")
@NamedQuery(name = "Pedido.obterTodos", query = "SELECT o FROM Pedido o WHERE o.cdCliente = :cdCliente")
public class Pedido implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "NUMERO")
	private int numero;
	@Column(name = "DATA")
	private Date data;
	@Column(name = "COD_CLIENTE")
	private int cdCliente;
	@Column(name = "SITUACAO")
	private char situacao;
	private static final long serialVersionUID = 1L;

	public Pedido() {
		super();
	}   
	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}   
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}   
	public int getCdCliente() {
		return this.cdCliente;
	}

	public void setCdCliente(int cdCliente) {
		this.cdCliente = cdCliente;
	}   
	public Character getSituacao() {
		return this.situacao;
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}
   
}
