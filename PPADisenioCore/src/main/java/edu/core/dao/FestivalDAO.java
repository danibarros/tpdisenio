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
	
}
