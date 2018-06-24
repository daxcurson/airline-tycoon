package airlinetycoon.datos;
import java.util.List;

import airlinetycoon.modelo.ObjetoDominio;

public interface GenericDao<T extends ObjetoDominio> 
{
	public List<T> readAll();
	public T readById(int id);
	public void save(T a);
}
