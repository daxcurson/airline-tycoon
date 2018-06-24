package airlinetycoon.datos.hibernate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import airlinetycoon.datos.GenericDao;
import airlinetycoon.modelo.ObjetoDominio;

public class GenericDaoImpl <T extends ObjetoDominio> implements GenericDao<T>
{
	protected static Logger log=LogManager.getLogger(GenericDaoImpl.class);
	protected SessionFactory sessionFactory;
	
	protected Class<T> type;

    @SuppressWarnings("unchecked")
	public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }

	@Override
	public List<T> readAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T readById(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(T a)
	{
		// TODO Auto-generated method stub
		
	}
    
}
