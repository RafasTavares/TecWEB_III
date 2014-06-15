package br.unit.ejb;

import java.util.List;

import javax.ejb.Local;

import br.unit.classes.*;

@Local
public interface GerenciarCategoriasLocal {
	
	public void inserirCategoria(Categoria categoria);
	public void alterarNomeCategoria(int codigo, String nome);
	public void removerCategoria(int codigo);
	public List<Categoria> obterCategoriaPorNome(String nome);
	public Categoria obterCategoriaPorCodigo(Integer codigo);
	public List<Categoria> listar();
	
	public List<Subcategoria> listarSubcategorias(int codigoCategoria);
	public void inserirSubcategoria(Subcategoria subcategoria);
	public void removerSubcategoria(Subcategoria subcategoria);
	public void alterarNomeSubcategoria(Subcategoria subcategoria);
	public int obterProximoCodSubcategoria(int cdCategoria);
	public Subcategoria obterSubcategoriaPorCodigo(int cdSubcategoria, int cdCategoria);
}
