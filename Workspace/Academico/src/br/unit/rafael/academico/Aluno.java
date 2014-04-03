package br.unit.rafael.academico;

import java.util.Date;



public class Aluno {
	private Matricula matricula;
	private Sexo sexo;
	private String nome;
	private EstadoCivil estadoCivil;
	private Date dtNascimento;
	private Nota nota;

	public Aluno() {

	}

	public Aluno(Matricula matricula, Sexo sexo, String nome,
			EstadoCivil estadoCivil, Date dtNascimento, Nota nota) {
		this.matricula = matricula;
		this.sexo = sexo;
		this.nome = nome;
		this.estadoCivil = estadoCivil;
		this.dtNascimento = dtNascimento;
		this.nota = nota;

	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}public void setNome(String nome) {
		this.nome = nome;
	}
	public void setNota(Nota nota) {
		this.nota = nota;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public Nota getNota() {
		return nota;
	}

	public Sexo getSexo() {
		return sexo;
	}

}
