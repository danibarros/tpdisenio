package edu.core.dao;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericRepository<T, ID extends Serializable> {

	/* (non-Javadoc)
	 * @see edu.ar.bases.proyectobase.domainmodel.repositories.IObjetoPersistenteRepository#findAll()
	 */
	public abstract Collection<T> findAll();

	/* (non-Javadoc)
	 * @see edu.ar.bases.proyectobase.domainmodel.repositories.IObjetoPersistenteRepository#save(edu.ar.bases.proyectobase.domainmodel.entities.interfaces.IObjetoPersistente)
	 */
	public abstract void save(T entity);

	/* (non-Javadoc)
	 * @see edu.ar.bases.proyectobase.domainmodel.repositories.IObjetoPersistenteRepository#findById(java.lang.Integer)
	 */
	public abstract T findById(ID id);

	public abstract Collection<T> find(String query);	
	public T load(ID id) throws Exception;
	public void delete(T entity);
	public void update(T entity);
}