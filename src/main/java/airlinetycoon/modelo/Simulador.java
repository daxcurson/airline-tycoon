package airlinetycoon.modelo;

import java.util.LinkedList;
import java.util.List;

import airlinetycoon.datos.CiudadDao;
import airlinetycoon.datos.hibernate.CiudadDaoHibernate;

public class Simulador
{
	private List<Ciudad> ciudades;
	private List<CambiosCiudadObserver> cambiosCiudades;
	private static Simulador instancia;
	private CiudadDao ciudadDao;
	
	private Simulador()
	{
		ciudades=new LinkedList<Ciudad>();
		cambiosCiudades=new LinkedList<CambiosCiudadObserver>();
		ciudadDao=new CiudadDaoHibernate();
	}
	public static Simulador getInstance()
	{
		if(instancia==null)
			instancia=new Simulador();
		return instancia;
	}
	public void cargarDatosIniciales()
	{
		java.util.List<Ciudad> listaCiudades=ciudadDao.readAll();
		for(Ciudad c:listaCiudades)
			this.agregarCiudad(c);
	}

	private void agregarCiudad(Ciudad c)
	{
		ciudades.add(c);
		for(CambiosCiudadObserver o:cambiosCiudades)
		{
			o.agregarCiudad(c);
		}
	}
	public void agregarCiudadObserver(CambiosCiudadObserver c)
	{
		this.cambiosCiudades.add(c);
	}
}
