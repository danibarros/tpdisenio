package edu.core.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import edu.core.entities.Banda;
import edu.core.entities.Noche;
import edu.core.entities.Pais;

public class BandaDAO extends GenericRepository<Banda, Integer>{

	public List<Banda> getAllBandas(){
		String hql = "from Banda";
		Query query = session.createQuery(hql);
		List<Banda> result = (List<Banda>) query.list();
		return result;
	}

	public Banda getBandaById(Integer id){
		return (Banda) session.get(Banda.class, id);
	}
	
	public Banda getBandaByNombre(String nombre){
		
		String hql = "from Banda where nombre = :bandaNombre ";
		Query query = session.createQuery(hql);
		query.setString("bandaNombre", nombre);
		Banda result = (Banda) query.list().get(0);
		return result;
	}
	@Override
	public Set<Banda> findAll(){
		Set<Banda> bandas = new HashSet<Banda>(super.findAll());
		return bandas;
	}
	
}
