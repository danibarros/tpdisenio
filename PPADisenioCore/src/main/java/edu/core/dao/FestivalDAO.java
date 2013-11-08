package edu.core.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import edu.core.entities.Banda;
import edu.core.entities.Estadio;
import edu.core.entities.Festival;

public class FestivalDAO extends GenericRepository<Festival, Integer>{

	public List<Festival> getAllFestivales(){
		String hql = "from Festival";
		Query query = session.createQuery(hql);
		List<Festival> result = (List<Festival>) query.list();
		return result;
	}
	
	public Set<Festival> findAll(){
		String hql = "from Festival";
		Query query = session.createQuery(hql);
		Set<Festival> result = (Set<Festival>) query.list();
		return result;
	}
	
	public Festival getFestivalById(Integer id){
		return (Festival) session.get(Festival.class, id);
	}

	
	public Festival getFestivalByName(String nombre){
		
		String hql = "from Festival where nombre = :festivalNombre ";
		Query query = session.createQuery(hql);
		query.setString("festivalNombre", nombre);
		Festival result = (Festival) query.list().get(0);
		return result;
	}
	
	
	
}
