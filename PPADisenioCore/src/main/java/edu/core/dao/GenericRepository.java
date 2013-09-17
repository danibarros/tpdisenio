package edu.core.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.persistence.HibernateUtil;

public abstract class GenericRepository<T,ID extends Serializable> implements IGenericRepository<T,ID> {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session;
	
	@SuppressWarnings("unchecked")
	public Class<T> entityClass = getDomainClass();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Class getDomainClass() {
	 	if (entityClass == null) {
			ParameterizedType thisType = (ParameterizedType) getClass()
 				.getGenericSuperclass();
			entityClass = (Class) thisType.getActualTypeArguments()[0];
	 	}
		return entityClass;
	}

	public GenericRepository() {
		session = sessionFactory.openSession();
    }

	public T load(ID id) throws Exception
	{
		return null;
	}
	
	public Collection<T> findAll()
	{
		return findByCriteria();
	}

	@SuppressWarnings("unchecked")
	public Collection<T> find(String query)
	{		
		return session.createQuery(query).list();
	}

	public void save(T entity)
	{
		session.save(entity);
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id)
	{
		return (T) session.get(entityClass, (Serializable) id);
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {
        Criteria crit = session.createCriteria(entityClass);
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
   }

	public void delete(T entity) {
		session.delete(entity);		
	}

	@Override
	public void update(T entity, ID id) {
		T entityRecuperada = findById(id);
		session.update(entityRecuperada);		
	}
	
}
