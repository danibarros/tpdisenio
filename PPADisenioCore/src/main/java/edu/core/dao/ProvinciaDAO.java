package edu.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.persistence.HibernateUtil;

import edu.core.entities.Localidad;
import edu.core.entities.Noche;
import edu.core.entities.Pais;
import edu.core.entities.Provincia;
import edu.core.entities.PuntoDeVenta;

public class ProvinciaDAO extends GenericRepository<Provincia, Integer>{
	
	public Provincia getProvinciaById(Integer id){
		return (Provincia) session.get(Provincia.class, id);
	}
	
	public List<Localidad> getLocalidadesByProvincia(Provincia provincia) {
		
		String hql = "select a from Localidad a inner join a.Provincia t where t.idProvincia = :idProvincia ";
		Query query = session.createQuery(hql);
		query.setInteger("idProvincia", provincia.getIdProvincia());
		
		List<Localidad> localidades = (List<Localidad>) query.list();
		
		return  localidades;
	}
	
	public List<Provincia> getAllProvincias(){
		String hql = " from Provincia";
		Query query = session.createQuery(hql);
		List<Provincia> result = (List<Provincia>) query.list();
		return result;
	}
	
}
