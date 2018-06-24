package airlinetycoon.datos.hibernate;

import java.util.List;
import javax.persistence.*;

import airlinetycoon.modelo.Ciudad;

public class CiudadDaoHibernate 
{
	public List<Ciudad> readAll() 
	{
		EntityManager manager = SessionManager.getEntityManager("aerolinea"); 
		EntityTransaction tran = manager.getTransaction(); 
		tran.begin(); 
		Query query = manager.createQuery("select c from Ciudad c"); 
		@SuppressWarnings("unchecked")
		List<Ciudad> list = query.getResultList();
		tran.commit(); 
		manager.close(); 
		return list;
	}

}
