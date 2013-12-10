package edu.core.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.persistence.HibernateUtil;

import edu.core.entities.Banda;
import edu.core.entities.Estadio;
import edu.core.entities.Festival;
import edu.core.entities.Noche;

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
		
		String hql = "from Festival where fest_nombre = :festivalNombre ";
		Query query = session.createQuery(hql);
		query.setString("festivalNombre", nombre);
		Festival result = (Festival) query.list().get(0);
		return result;
	}
	
	public int getUltimoFestival(){
		String sql = "Select Max(festival_id) "
				+ " from ppa_disenio.festival ";
		Query query = session.createSQLQuery(sql);
		int result = (Integer) query.list().get(0);
		return result;
	}
	
	public void cambiarMaximo(int max){
		String sql = "ALTER TABLE ppa_disenio.festival AUTO_INCREMENT = :max";
		Query query = session.createSQLQuery(sql);
		query.setInteger("max", max);
	}
	
	public void commit(){
        session.flush();
        session.clear();
	}
	
	public void guardar(Festival festival){
		
		Transaction tx = null;
		try {

		    tx = super.session.beginTransaction();
		    SQLQuery tempQuery = super.session.createSQLQuery("insert into ppa_disenio.festival " +
		    	"(festival_id,Estadios_estadio_id,fecha_inicio,fest_nombre) values (:festivalId,:estadioId,:fecha,:nombre);");
		    tempQuery.setInteger("festivalId", festival.getIdFestival());
		    tempQuery.setInteger("estadioId", festival.getEstadio().getIdEstadio());
		    tempQuery.setDate("fecha", festival.getFechaInicio());
		    tempQuery.setString("nombre", festival.getNombre());
		    tempQuery.executeUpdate();	
		    for(Noche noche: festival.getNoches()){
			    tempQuery = super.session.createSQLQuery("UPDATE ppa_disenio.noches " +
			    		"SET Festival_festival_id = :festivalId Where ppa_disenio.noches.noche_id = :nocheId");
			    tempQuery.setInteger("festivalId", festival.getIdFestival());
			    tempQuery.setInteger("nocheId", noche.getIdNoche());
			    tempQuery.executeUpdate();	
			}
		    tx.commit();
		}
		catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    throw e; // or display error message
		}
		finally {
			close();
		}
	}
	
}
