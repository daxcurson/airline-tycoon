package airlinetycoon.simulador;

import java.util.LinkedList;
import java.util.List;

import airlinetycoon.datos.CiudadDao;
import airlinetycoon.modelo.Ciudad;
import airlinetycoon.modelo.Configurador;

public class Simulador 
{
	private static Simulador me;
	private List<Ciudad> ciudades;
	private AgenciaViajes agencia;
	
	private Simulador()
	{
		setCiudades(new LinkedList<Ciudad>());
		setAgencia(new AgenciaViajes());
		cargarCiudades();
	}
	public static Simulador getInstance()
	{
		if(me==null)
			me=new Simulador();
		return me;
	}
	public List<Ciudad> getCiudades() {
		return ciudades;
	}
	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
	public AgenciaViajes getAgencia() {
		return agencia;
	}
	public void setAgencia(AgenciaViajes agencia) {
		this.agencia = agencia;
	}
	public void agregarCiudad(Ciudad c)
	{
		ciudades.add(c);
	}
	private void cargarCiudades()
	{
		CiudadDao ciudadDao;
		try
		{
			ciudadDao=(CiudadDao) Configurador.getInstance().DarRepositorio("Ciudad");
			java.util.List<Ciudad> listaCiudades=ciudadDao.readAll();
			for(Ciudad c:listaCiudades)
				this.agregarCiudad(c);
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
		}
	}
}
