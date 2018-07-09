package airlinetycoon.datos.hibernate;

import airlinetycoon.datos.AvionDao;
import airlinetycoon.modelo.Avion;

public class AvionDaoHibernate extends GenericDaoImpl<Avion>
implements AvionDao
{
	@Override
	protected String selectAll()
	{
		return "select a from Avion a";
	}
	@Override
	protected String selectById()
	{
		// 
		return "select a from Avion a where a.id=";
	}
}
