package airlinetycoon.datos.hibernate;

import java.util.List;
import javax.persistence.*;

import airlinetycoon.datos.CiudadDao;
import airlinetycoon.modelo.Ciudad;

public class CiudadDaoHibernate implements CiudadDao
{
	public List<Ciudad> readAll() 
	{
		EntityManager manager = SessionManager.getEntityManager("aerolinea"); 
		EntityTransaction tran = manager.getTransaction(); 
		tran.begin(); 
		Query query = manager.createQuery("select c from Ciudad c join fetch c.aeropuertos"); 
		@SuppressWarnings("unchecked")
		List<Ciudad> list = query.getResultList();
		tran.commit(); 
		manager.close(); 
		return list;
	}

	@Override
	public Ciudad readById(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Ciudad a)
	{
		// TODO Auto-generated method stub
		
	}

}
