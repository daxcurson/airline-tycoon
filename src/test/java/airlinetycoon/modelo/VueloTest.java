package airlinetycoon.modelo;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.BeforeClass;

public class VueloTest 
{
	private static airlinetycoon.simulador.Simulador simulador;
	@BeforeClass
	public static void cargarSimulacion()
	{
		simulador=airlinetycoon.simulador.Simulador.getInstance();
	}
	@Test
	public void test()
	{
		// Cargamos las ciudades y vemos que pasa.
		try
		{
			simulador.getCiudades();
		}
		catch(Exception e)
		{
			fail("Falla con excepcion: "+e);
		}
	}
}
