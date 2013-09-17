package edu.core.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;

public abstract class GenericRepository<T,ID extends Serializable> implements IGenericRepository<T,ID> {

	protected SessionFactory sessionFactory;
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
    }

	public T load(ID id) throws Exception
	{
		return null;
//		return (T)this.getHibernateTemplate().load(instancia.getClass(), id);
	}
	
	public Collection<T> findAll()
	{
//		sessionFactory.getCurrentSession().
		return findByCriteria();
	}

	@SuppressWarnings("unchecked")
	public Collection<T> find(String query)
	{		
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}

	public void save(T entity)
	{
		sessionFactory.getCurrentSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id)
	{
		return (T) sessionFactory.getCurrentSession().get(entityClass, (Serializable) id);
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {
		Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(entityClass);
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
   }

	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);		
	}

	@Override
	public void update(T entity, ID id) {
		T entityRecuperada = findById(id);
		sessionFactory.getCurrentSession().update(entityRecuperada);		
	}
	
}
