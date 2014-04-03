package br.unit.rafael.academico;

public class Nota implements Comparable<Nota> {
	private double valor;

	public Nota(double valor) {
		this.valor = (int) valor;
	}

	public double getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return valor + "";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Nota) {
			Nota nt = (Nota) obj;
			return this.valor == nt.valor;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (int) valor;
	}

	@Override
	public int compareTo(Nota nota) {
		if (valor > nota.valor)
			return 1;
		if (valor < nota.valor)
			return -1;
		return 0;
	}

}
