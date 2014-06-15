package br.unit.classes;

import java.io.Serializable;
import java.lang.Character;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Aluno
 *
 */
@Entity

@Table(catalog = "DB", schema = "PUBLIC", name = "TB_ALUNO")
@NamedQuery(name = "Aluno.obterTodos", query = "SELECT o FROM Aluno o")
public class Aluno implements Serializable {

	   
	@Id
	@Column(name = "MATRICULA")
	private Integer matricula;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "SEXO")
	private Character sexo;
	@Column(name = "NOTA_1")
	private Double nota1;
	@Column(name = "NOTA_2")
	private Double nota2;
	@Column(name = "NOTA_3")
	private Double nota3;
	private static final long serialVersionUID = 1L;

	public Aluno() {
		super();
	}   
	public Integer getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public Character getSexo() {
		return this.sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}   
	public Double getNota1() {
		return this.nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}   
	public Double getNota2() {
		return this.nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}   
	public Double getNota3() {
		return this.nota3;
	}

	public void setNota3(Double nota3) {
		this.nota3 = nota3;
	}
   
}
