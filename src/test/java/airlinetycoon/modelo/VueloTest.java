package airlinetycoon.modelo;

import org.junit.Test;

import airlinetycoon.simulador.AgenciaViajes;

import static org.junit.Assert.*;

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
}
