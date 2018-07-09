package airlinetycoon.datos.hibernate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import airlinetycoon.datos.GenericDao;
import airlinetycoon.modelo.ObjetoDominio;

public abstract class GenericDaoImpl <T extends ObjetoDominio> implements GenericDao<T>
{
	protected static Logger log=LogManager.getLogger(GenericDaoImpl.class);
	protected SessionFactory sessionFactory;
	
	protected Class<T> type;
	protected abstract String selectAll();
	protected abstract String selectById();

    @SuppressWarnings("unchecked")
	public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }

	@Override
	public List<T> readAll()
	{
		EntityManager manager = SessionManager.getEntityManager("aerolinea"); 
		EntityTransaction tran = manager.getTransaction(); 
		tran.begin(); 
		Query query = manager.createQuery(selectAll()); 
		@SuppressWarnings("unchecked")
		List<T> list = query.getResultList();
		tran.commit(); 
		manager.close(); 
		return list;
	}

	@Override
	public T readById(int id)
	{
		EntityManager manager = SessionManager.getEntityManager("aerolinea"); 
		EntityTransaction tran = manager.getTransaction(); 
		tran.begin(); 
		Query query = manager.createQuery(selectById()+id); 
		@SuppressWarnings("unchecked")
		T list = (T) query.getSingleResult();
		tran.commit(); 
		manager.close(); 
		return list;
	}

	@Override
	public void save(T a)
	{
		EntityManager manager=SessionManager.getEntityManager("aerolinea");
		EntityTransaction tran=manager.getTransaction();
		tran.begin();
		manager.persist(a);
		tran.commit();
		manager.close();
	}
    
}
