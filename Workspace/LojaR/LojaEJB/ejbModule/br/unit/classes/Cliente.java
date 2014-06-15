package br.unit.classes;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cliente
 *
 */
@Entity

@Table(catalog = "DB", schema = "PUBLIC", name = "TB_CLIENTE")
@NamedQuery(name = "Cliente.obterTodos", query = "SELECT o FROM Cliente o")
public class Cliente implements Serializable {

	   
	@Id
	@Column(name = "CODIGO")
	private int codigo;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "CPF")
	private String cpf;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "SENHA")
	private String senha;
	@Column(name = "NASCIMENTO")
	private Date nascimento;
	@Column(name = "ENDERECO")
	private String endereco;
	@Column(name = "SEXO")
	private char sexo;
	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
	}   
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}   
	public Date getNascimento() {
		return this.nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}   
	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}   
	public char getSexo() {
		return this.sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
   
}
