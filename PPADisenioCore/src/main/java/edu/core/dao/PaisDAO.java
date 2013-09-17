package edu.core.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.persistence.HibernateUtil;

import edu.core.entities.Pais;
import edu.core.entities.Provincia;

public class PaisDAO extends GenericRepository<Pais, Integer>{
	
	public List<Provincia> getProvinciasByPais(Pais pais) {
		
		String hql = "select a from Provincia a inner join a.pais t where t.idPais = :idPais ";
		Query query = session.createQuery(hql);
		query.setInteger("idPais", pais.getIdPais());
		
		List<Provincia> provincias = (List<Provincia>) query.list();
		
		return  provincias;
	}
	
	public Pais getPaisById(Integer idPais){
		return (Pais) session.get(Pais.class, idPais);
	}

}
