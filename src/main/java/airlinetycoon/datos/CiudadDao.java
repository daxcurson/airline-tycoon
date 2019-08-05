package airlinetycoon.datos;

import airlinetycoon.modelo.Ciudad;

public interface CiudadDao extends GenericDao<Ciudad>
{
	public Ciudad readByName(String name);
}
