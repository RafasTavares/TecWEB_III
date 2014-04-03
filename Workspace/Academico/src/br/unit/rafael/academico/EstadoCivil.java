package br.unit.rafael.academico;

public class EstadoCivil {
	private String relacionamento;

	public EstadoCivil(String relacionamento) {
		this.relacionamento = relacionamento;
	}

	public String getRelacionamento() {
		return relacionamento;
	}

	@Override
	public String toString() {
		return "Relacionamento é " + relacionamento;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EstadoCivil) {
			EstadoCivil ec = (EstadoCivil) obj;
			return this.relacionamento == ec.relacionamento;
		}
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
