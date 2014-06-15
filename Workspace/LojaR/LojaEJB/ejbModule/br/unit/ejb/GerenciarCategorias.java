package br.unit.ejb;

import java.util.List;

import br.unit.classes.Categoria;
import br.unit.classes.Subcategoria;
import br.unit.classes.SubcategoriaPK;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class GerenciarCategorias
 */
@Stateless
@Local(GerenciarCategoriasLocal.class)
@LocalBean
@WebService
public class GerenciarCategorias implements GerenciarCategoriasLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
     * @see GerenciarCategoriasLocal#obterCategoriaPorNome(String)
     */
    public List<Categoria> obterCategoriaPorNome(String nome) {
        // TODO Auto-generated method stub
			return null;
    }

	/**
     * @see GerenciarCategoriasLocal#alterarNomeCategoria(int, String)
     */
    
    public void alterarNomeCategoria(int codigo, String nome) {
        Categoria categoria = em.find(Categoria.class, codigo);
        if (categoria != null){
        	categoria.setNome(nome);
        }
    }

	/**
     * @see GerenciarCategoriasLocal#removerCategoria(int)
     */
    public void removerCategoria(int codigo) {
    	Categoria categoria = em.find(Categoria.class, codigo);
        if (categoria != null){
        	em.remove(categoria);
        }
    }

	/**
     * @see GerenciarCategoriasLocal#inserirCategoria(Categoria)
     */
    public void inserirCategoria(Categoria categoria) {
        em.persist(categoria);
    }

	/**
     * @see GerenciarCategoriasLocal#listar()
     */
    @WebMethod
    public List<Categoria> listar() {
        TypedQuery<Categoria> query = em.createNamedQuery("Categoria.obterTodos", Categoria.class);
        return query.getResultList();
    }

	@Override
	public Categoria obterCategoriaPorCodigo(Integer codigo) {
		return em.find(Categoria.class, codigo);
	}

	@Override
	public List<Subcategoria> listarSubcategorias(int codigoCategoria) {
		TypedQuery<Subcategoria> query = em.createNamedQuery("Subcategoria.obterSubcategorias", Subcategoria.class);
		query.setParameter("codigoCategoria", codigoCategoria );
		return query.getResultList();
	}

	@Override
	public void inserirSubcategoria(Subcategoria subcategoria) {
		subcategoria.setCodigo(obterProximoCodSubcategoria(subcategoria.getCdCategoria()));
		em.persist(subcategoria);
	}

	@Override
	public void removerSubcategoria(Subcategoria subcategoria) {
		em.remove(subcategoria);
	}

	@Override
	public void alterarNomeSubcategoria(Subcategoria pSubcategoria) {
		SubcategoriaPK subcategoriaPk = new SubcategoriaPK();
		subcategoriaPk.setCdCategoria(pSubcategoria.getCdCategoria());
		subcategoriaPk.setCodigo(pSubcategoria.getCodigo());
		Subcategoria subcategoria = em.find(Subcategoria.class, subcategoriaPk);
        if (subcategoria != null){
        	subcategoria.setNome(pSubcategoria.getNome());
        }
	}

	@Override
	public Subcategoria obterSubcategoriaPorCodigo(int cdSubcategoria,
			int cdCategoria) {
		SubcategoriaPK subcategoriaPk = new SubcategoriaPK();
		subcategoriaPk.setCodigo(cdSubcategoria);
		subcategoriaPk.setCdCategoria(cdCategoria);
		return em.find(Subcategoria.class, subcategoriaPk);
	}

	@Override
	public int obterProximoCodSubcategoria(int cdCategoria) {
		TypedQuery<Integer> query = em.createNamedQuery("Subcategoria.obterProximoCodigoSubcategoria", Integer.class);
		query.setParameter("codigoCategoria", cdCategoria);
		Integer proxNum = 0;
		try {
			proxNum = query.getSingleResult();
		} catch (NoResultException e) {
			return 1;
		} catch (NullPointerException e) {
			return 1;
		}
		if (proxNum == null){
			return 1;
		}
		proxNum = proxNum + 1;
		return proxNum;
	}

}
