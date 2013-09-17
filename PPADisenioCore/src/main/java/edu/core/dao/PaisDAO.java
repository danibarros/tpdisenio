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

	private Session session;

	public PaisDAO() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public Pais getPaisByIdPais(int idPais) {
		return (Pais) session.get(new Pais().getClass(), idPais );
	}
	
	public List<Provincia> getProvinciasByPais(Pais pais) {
		
		String hql = "select a from Provincia a inner join a.pais t where t.idPais = :idPais ";
		Query query = session.createQuery(hql);
		query.setLong("idPais", pais.getIdPais());
		
		List<Provincia> provincias = (List<Provincia>) query.list();
		
		return  provincias;
	}

}
