package br.unit.rafael.academico;

/*
 * A classe Sexo é usada para referenciar o sexo do Aluno
 * */
public class Sexo {
	private static char tipo;

	
	public Sexo(char pSexo) {
		this.tipo =  pSexo;
	}

	public static char getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
	return"";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Sexo) {
			Sexo ec = (Sexo) obj;
			return this.tipo == ec.tipo;
		}
		return false;
	}

}
