package br.unit.rafael.academico;

/*
 * A classe matricula é usada para criar um código referente a uma matricula.
 * */
public class Matricula implements Comparable<Matricula> {

	private static int codigo;

	public Matricula(int pCodigo) {
		this.codigo =  pCodigo;
	}

	public static int getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		// return Integer.toString(valor);
		return "Código da matricula : " + getCodigo();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Matricula) {
			Matricula ec = (Matricula) obj;
			return this.codigo == ec.codigo;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return codigo;
	}

	@Override
	public int compareTo(Matricula mat) {
		if (codigo < mat.codigo) {
			return -1;
		}
		if (codigo > mat.codigo) {
			return 1;
		}
		return 0;
	}
}
