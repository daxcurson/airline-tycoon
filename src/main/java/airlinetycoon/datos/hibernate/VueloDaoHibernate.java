package airlinetycoon.datos.hibernate;

import java.util.List;
import javax.persistence.*;

import airlinetycoon.datos.VueloDao;
import airlinetycoon.modelo.Vuelo;


public class VueloDaoHibernate extends GenericDaoImpl<Vuelo> implements VueloDao 
{
	/* (non-Javadoc)
	 * @see datos.hibernate.VueloDao#readAll()
	 */
	public List<Vuelo> readAll() 
	{
		EntityManager manager = SessionManager.getEntityManager("aerolinea"); 
		EntityTransaction tran = manager.getTransaction(); 
		tran.begin(); 
		Query query = manager.createQuery("select a from Vuelo a"); 
		@SuppressWarnings("unchecked")
		List<Vuelo> list = query.getResultList();
		tran.commit(); 
		manager.close(); 
		return list;
	}

	@Override
	protected String selectAll() {
		return "select a from Vuelo a";
	}

	@Override
	protected String selectById() {
		return "select a from Vuelo a where a.id=";
	}

}
