package br.unit.rafael.academico;

import java.util.ArrayList;

public class Classe {

	public ArrayList<Aluno> todosAlunos = new ArrayList<Aluno>();

	public void AdicionarAlunos(Aluno aluno) {
		todosAlunos.add(aluno);
		
	}

	public ArrayList<Aluno> ListarAlunos() {
		return todosAlunos;
	}

	public Aluno BuscarAlunoPorMatricula(int matricula) {

		for (int i = 0; i < ListarAlunos().size(); i++) {
			Aluno aluno = new Aluno();
			aluno.getMatricula().equals(matricula);
			return aluno;
		}
		return null;
	}

	public boolean ExcluirAluno(int matricula) {
		Aluno aluno = BuscarAlunoPorMatricula(matricula);
		ListarAlunos().remove(aluno);
		return false;
	}

}
