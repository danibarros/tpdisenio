package edu.core.dao;

import org.hibernate.Query;

import edu.core.entities.Banda;
import edu.core.entities.Estadio;
import edu.core.entities.Vendedor;

public class VendedorDAO extends GenericRepository<Estadio, Integer>{
	
	public Vendedor getVendedorByUser(String user){
			
		String hql = "from Vendedor where vendedor_user = :vendedorNombre ";
		Query query = session.createQuery(hql);
		query.setString("vendedorNombre", user);
		Vendedor result = null;
		if(!query.list().isEmpty()){
			result = (Vendedor) query.list().get(0);
		}
		return result;
	}
}
