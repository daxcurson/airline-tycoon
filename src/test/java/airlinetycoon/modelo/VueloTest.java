package airlinetycoon.modelo;

import org.junit.Test;

import airlinetycoon.datos.CiudadDao;
import airlinetycoon.simulador.AgenciaViajes;
import airlinetycoon.simulador.SimuladorUtils;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;

public class VueloTest 
{
	private static airlinetycoon.simulador.Simulador simulador;
	@BeforeClass
	public static void cargarSimulacion()
	{
		simulador=airlinetycoon.simulador.Simulador.getInstance();
		Reloj.getInstance().iniciarReloj();
	}
	@Test
	public void test01cargarCiudades()
	{
		// Cargamos las ciudades y vemos que pasa.
		try
		{
			List<Ciudad> lista=simulador.getCiudades();
			System.out.println("Cargadas las ciudades!");
			for(Ciudad c:lista)
			{
				System.out.println("Ciudad: "+c.getNombre());
			}
		}
		catch(Exception e)
		{
			fail("Falla con excepcion: "+e);
		}
	}
	@Test
	public void test02cargarModelosAvion()
	{
		// Cargamos los modelos de avion.
		try
		{
			List<Modeloavion> lista=simulador.getModelosAvion();
			System.out.println("Cargados los modelos de avion!");
			for(Modeloavion c:lista)
			{
				System.out.println("Modelo: "+c.getModelo());
			}
		}
		catch(Exception e)
		{
			fail("Falla con excepcion: "+e);
		}
	}
	@Test
	public void test03generarVuelo()
	{
		AgenciaViajes v=simulador.getAgencia();
		Vuelo vuelo=v.generarVuelo();
		System.out.println("Genere este vuelo: desde "+vuelo.getOrigen().getCodigo()+" hasta "+vuelo.getDestino().getCodigo());
	}
	@Test
	public void test04calcularDistancia()
	{
		AgenciaViajes v=simulador.getAgencia();
		Vuelo vuelo=v.generarVuelo();
		// Calculo la distancia.
		Posicion desde=new Posicion();
		desde.setLatitud(vuelo.getOrigen().getCiudad().getLatitud());
		desde.setLongitud(vuelo.getOrigen().getCiudad().getLongitud());
		Posicion hasta=new Posicion();
		hasta.setLatitud(vuelo.getDestino().getCiudad().getLatitud());
		hasta.setLongitud(vuelo.getDestino().getCiudad().getLongitud());
		double distancia=SimuladorUtils.calcularDistancia(desde, hasta);
		System.out.println("La distancia entre "+vuelo.getOrigen().getCiudad()+" y "+vuelo.getDestino().getCiudad()+" es de "+distancia+" kilometros.");
	}
	@Test
	public void test05calcularDistanciaLimaSantiago()
	{
		CiudadDao ciudadDao;
		try {
			ciudadDao = (CiudadDao) Configurador.getInstance().DarRepositorio("Ciudad");
			Ciudad lima=ciudadDao.readByName("Lima");
			Ciudad santiago=ciudadDao.readByName("Santiago");
			Posicion desde=new Posicion();
			desde.setLatitud(lima.getLatitud());
			desde.setLongitud(lima.getLongitud());
			Posicion hasta=new Posicion();
			hasta.setLatitud(santiago.getLatitud());
			hasta.setLongitud(santiago.getLongitud());
			double distancia=SimuladorUtils.calcularDistancia(desde, hasta);
			System.out.println("La distancia entre Lima y Santiago es "+distancia+" kilometros.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
