package airlinetycoon.datos.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import airlinetycoon.datos.ModeloavionDao;
import airlinetycoon.modelo.Modeloavion;

public class ModeloavionDaoHibernate extends GenericDaoImpl<Modeloavion> implements ModeloavionDao
{

	@Override
	protected String selectAll()
	{
		return "select a from Modeloavion a";
	}

	@Override
	protected String selectById()
	{
		return "select a from Modeloavion a where a.id=";
	}
	
	public Modeloavion readByName(String name)
	{
		EntityManager manager = SessionManager.getEntityManager("aerolinea"); 
		EntityTransaction tran = manager.getTransaction(); 
		tran.begin(); 
		Query query = manager.createQuery("select c from Modeloavion where c.modelo=:name");
		query.setParameter("name", name);
		Modeloavion resultado=(Modeloavion) query.getSingleResult();
		tran.commit(); 
		manager.close(); 
		return resultado;
	}
}
