package edu.core.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import edu.core.entities.Banda;
import edu.core.entities.Butaca;
import edu.core.entities.Categoria;
import edu.core.entities.Pais;

public class CategoriaDAO extends GenericRepository<Categoria, Integer>{
	
	public List<Categoria> getAllCategorias(){
		String hql = "from Categoria ";
		Query query = session.createQuery(hql);
		List<Categoria> categorias = (List<Categoria>) query.list();
		return  categorias;
	}
	
	public Categoria getCategoriaById(Integer id){
		return (Categoria) session.get(Categoria.class, id);
	}
	
	@Override
	public Set<Categoria> findAll(){
		
		String hql = "from Categoria";
		Query query = session.createQuery(hql);
		Set<Categoria> categorias =new HashSet<Categoria>(query.list());
		
		return categorias;
	}

}
