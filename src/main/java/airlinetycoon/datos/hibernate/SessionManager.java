package airlinetycoon.datos.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionManager
{
	public static EntityManager getEntityManager(String entity)
	{
		EntityManagerFactory managerFactory =Persistence.createEntityManagerFactory(entity); 
		EntityManager manager = managerFactory.createEntityManager();
		return manager;
	}
}