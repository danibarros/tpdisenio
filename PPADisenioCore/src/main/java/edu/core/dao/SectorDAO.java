package edu.core.dao;

import java.util.List;

import org.hibernate.Query;

import edu.core.entities.Banda;
import edu.core.entities.PuntoDeVenta;
import edu.core.entities.Sector;

public class SectorDAO extends GenericRepository<Sector, Integer>{
	
	public Sector getSectorById(Integer id){
		return (Sector) session.get(Sector.class, id);
	}
	
	public List<Sector> getAllSectores(){
		String hql = " from Sector";
		Query query = session.createQuery(hql);
		List<Sector> result = (List<Sector>) query.list();
		return result;
	}

}
