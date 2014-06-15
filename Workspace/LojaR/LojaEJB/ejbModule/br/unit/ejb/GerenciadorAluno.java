package br.unit.ejb;

import java.util.List;

import br.unit.classes.Aluno;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class GerenciadorAluno
 */
@Stateless
@Local(GerenciadorAlunoLocal.class)
@LocalBean
public class GerenciadorAluno implements GerenciadorAlunoLocal {

	@PersistenceContext
	private EntityManager em;

    public GerenciadorAluno() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see GerenciadorAlunoLocal#obterAlunos()
     */
    public List<Aluno> obterAlunos() {
		TypedQuery<Aluno> query = em.createNamedQuery("Aluno.obterTodos", Aluno.class);
		return query.getResultList();
    }

}
