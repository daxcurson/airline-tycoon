package airlinetycoon.datos.hibernate;

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

}
