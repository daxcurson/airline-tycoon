package airlinetycoon.simulador;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import airlinetycoon.datos.CiudadDao;
import airlinetycoon.datos.ModeloavionDao;
import airlinetycoon.modelo.Ciudad;
import airlinetycoon.modelo.Configurador;
import airlinetycoon.modelo.Modeloavion;

public class Simulador 
{
	private static Simulador me;
	private List<Ciudad> ciudades;
	private AgenciaViajes agencia;
	private HashMap<String,Modeloavion> modelos;
	private double precioKerosene;
	
	private Simulador()
	{
		setCiudades(new LinkedList<Ciudad>());
		setAgencia(new AgenciaViajes());
		cargarCiudades();
		cargarModelosAvion();
		// quiza tenga que haber una petrolera que provea el petroleo???
		// Por ahora simplemente vamos a dar un precio, que podra ser o no
		// actualizado con algun criterio.
		precioKerosene=10; //en $ por litro
	}
	public double getPrecioKerosene()
	{
		return precioKerosene;
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
	public HashMap<String,Modeloavion> getModelosAvion()
	{
		return modelos;
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
	public Modeloavion getModelo(String modelo)
	{
		return modelos.get(modelo);
	}
	private void cargarModelosAvion()
	{
		ModeloavionDao modeloavionDao;
		modelos=new HashMap<String,Modeloavion>();
		try
		{
			modeloavionDao=(ModeloavionDao) Configurador.getInstance().DarRepositorio("Modeloavion");
			List<Modeloavion> modelosAvion=modeloavionDao.readAll();
			Iterator<Modeloavion> i=modelosAvion.listIterator();
			while(i.hasNext())
			{
				Modeloavion a=i.next();
				modelos.put(a.getModelo(), a);
			}
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
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
