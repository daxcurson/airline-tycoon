package airlinetycoon.modelo;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import airlinetycoon.datos.CiudadDao;

public class Simulador
{
	private List<Ciudad> ciudades;
	private List<Avion> aviones;
	private List<CambiosCiudadObserver> cambiosCiudades;
	private List<CambiosAvionObserver> cambiosAviones;
	private List<CambiosDineroObserver> cambiosDinero;
	private static Simulador instancia;
	private CiudadDao ciudadDao;
	private BigDecimal dinero;
	//private Reloj reloj;
	
	private Simulador()
	{
		ciudades=new LinkedList<Ciudad>();
		aviones=new LinkedList<Avion>();
		cambiosCiudades=new LinkedList<CambiosCiudadObserver>();
		cambiosAviones=new LinkedList<CambiosAvionObserver>();
		cambiosDinero=new LinkedList<CambiosDineroObserver>();
		try
		{
			ciudadDao=(CiudadDao) Configurador.getInstance().DarRepositorio("Ciudad");
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (InstantiationException e)
		{
			e.printStackTrace();
		} 
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		dinero=new BigDecimal(0);
		//reloj=Reloj.getInstance();
	}
	public static Simulador getInstance()
	{
		if(instancia==null)
			instancia=new Simulador();
		return instancia;
	}
	public void cargarDatosIniciales()
	{
		cargarCiudades();
		// Aca cargo un dinero inicial.
		dinero=new BigDecimal(10000000.00);
		this.dispararCambioDinero();
	}
	public void cargarCiudades()
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
	public void agregarDineroObserver(CambiosDineroObserver c)
	{
		this.cambiosDinero.add(c);
	}
	public void agregarAvionObserver(CambiosAvionObserver c)
	{
		this.cambiosAviones.add(c);
	}
	public void agregarAvion(Avion a)
	{
		aviones.add(a);
		for(CambiosAvionObserver o:cambiosAviones)
		{
			o.agregarAvion(a);
		}
	}
	public void dispararCambioDinero()
	{
		for(CambiosDineroObserver o:cambiosDinero)
		{
			o.nuevoDinero(dinero);
		}
	}
}
