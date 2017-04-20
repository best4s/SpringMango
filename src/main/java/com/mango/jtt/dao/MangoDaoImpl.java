/**
 * 
 */
package com.mango.jtt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author HHL
 *
 * @date 2016��11��30��
 */
@Repository
public class MangoDaoImpl implements IMangoDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	/* (non-Javadoc)
	 * @see com.mango.jtt.dao.MangoDao#list(java.lang.String)
	 */
	@Override
	public List list(String querySql) {
		Query<?> query = currentSession().createQuery(querySql);
		return query.getResultList();
	}

	@Override
	public Object get(Class clazz, String productId) {
		return currentSession().get(clazz, productId);
	}

	@Override
	public void saveBean(Object object) {
		currentSession().save(object);

	}

	@Override
	public void updateBean(Object object) {
		currentSession().update(object);

	}

}