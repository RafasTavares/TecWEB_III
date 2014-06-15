package br.unit.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;

import br.unit.classes.Aluno;

@LocalBean
public interface GerenciadorAlunoLocal {
	public List<Aluno> obterAlunos();
}
