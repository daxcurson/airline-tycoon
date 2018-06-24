package airlinetycoon.datos.hibernate;
import java.util.*;
import javax.persistence.*;

import airlinetycoon.datos.AvionDao;
import airlinetycoon.modelo.Avion;

public class AvionDaoHibernate implements AvionDao
{
	public List<Avion> readAll() 
	{
		EntityManager manager = SessionManager.getEntityManager("aerolinea"); 
		EntityTransaction tran = manager.getTransaction(); 
		tran.begin(); 
		Query query = manager.createQuery("select a from Avion a"); 
		@SuppressWarnings("unchecked")
		List<Avion> list = query.getResultList();
		tran.commit(); 
		manager.close(); 
		return list;
	}
	public void save(Avion a)
	{
		EntityManager manager=SessionManager.getEntityManager("aerolinea");
		EntityTransaction tran=manager.getTransaction();
		tran.begin();
		manager.persist(a);
		tran.commit();
		manager.close();
	}
	@Override
	public Avion readById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
