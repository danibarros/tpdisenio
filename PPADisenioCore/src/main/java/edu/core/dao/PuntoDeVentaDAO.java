package edu.core.dao;

import java.util.List;

import org.hibernate.Query;

import edu.core.entities.Banda;
import edu.core.entities.PuntoDeVenta;

public class PuntoDeVentaDAO extends GenericRepository<PuntoDeVenta, Integer>{

	public PuntoDeVenta getPuntoDeVentaById(Integer id){
		return (PuntoDeVenta) session.get(PuntoDeVenta.class, id);
	}
	
	public List<PuntoDeVenta> getAllPuntosDeVenta(){
		String hql = " from PuntoDeVenta";
		Query query = session.createQuery(hql);
		List<PuntoDeVenta> result = (List<PuntoDeVenta>) query.list();
		return result;
	}
}
