package airlinetycoon.modelo;

import org.junit.Test;

import airlinetycoon.datos.CiudadDao;
import airlinetycoon.simulador.AgenciaViajes;
import airlinetycoon.simulador.SimuladorUtils;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

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
			HashMap<String, Modeloavion> lista=simulador.getModelosAvion();
			System.out.println("Cargados los modelos de avion!");
			for(Entry<String, Modeloavion> c:lista.entrySet())
			{
				System.out.println("Modelo: "+c.getValue().getModelo());
			}
		}
		catch(Exception e)
		{
			fail("Falla con excepcion: "+e);
		}
	}
	@Test
	public void test06cargarAvion()
	{
		try
		{
			Modeloavion modelo=simulador.getModelo("Airbus A380");
			System.out.println("Leido: "+modelo.getModelo());
		}
		catch(Exception e)
		{
			System.out.println("Falla: "+e);
			fail();
		}
	}
	@Test
	public void test07chequearDistancia()
	{
		Modeloavion modelo1;
		Modeloavion modelo2;
		try
		{
			modelo1=simulador.getModelo("Airbus A380");
			modelo2=simulador.getModelo("Airbus A300");
			System.out.println("Leido: "+modelo1.getModelo());
			// Veamos si un avion puede cubrir una distancia
			AgenciaViajes v=simulador.getAgencia();
			Vuelo vuelo=v.generarVuelo();
			// Ahora, veamos la distancia.
			Posicion desde=new Posicion();
			desde.setLatitud(vuelo.getOrigen().getCiudad().getLatitud());
			desde.setLongitud(vuelo.getOrigen().getCiudad().getLongitud());
			Posicion hasta=new Posicion();
			hasta.setLatitud(vuelo.getDestino().getCiudad().getLatitud());
			hasta.setLongitud(vuelo.getDestino().getCiudad().getLongitud());
			double distancia=SimuladorUtils.calcularDistancia(desde, hasta);
			System.out.println("La distancia entre "+vuelo.getOrigen().getCiudad()+" y "+vuelo.getDestino().getCiudad()+" es "+distancia+" kilometros");
			System.out.println("La autonomia del "+modelo1.getModelo()+" es "+modelo1.getAutonomia());
			System.out.println("La autonomia del "+modelo2.getModelo()+" es "+modelo2.getAutonomia());
			mostrarEstadisticasVuelo(vuelo,distancia,modelo1);
			mostrarEstadisticasVuelo(vuelo,distancia,modelo2);
		}
		catch(Exception e)
		{
			System.out.println("Falla: "+e);
			fail();
		}
	}
	private void mostrarEstadisticasVuelo(Vuelo vuelo,double distancia,Modeloavion modelo1)
	{
		if(distancia>modelo1.getAutonomia())
		{
			System.out.println("El modelo "+modelo1.getModelo()+" no puede volar desde "+vuelo.getOrigen().getCiudad()+" hasta "+vuelo.getDestino().getCiudad());
		}
		else
		{
			System.out.println("El modelo "+modelo1.getModelo()+" puede volar desde "+vuelo.getOrigen().getCiudad()+" hasta "+vuelo.getDestino().getCiudad());
			// Calculamos el combustible que gasta.
			// El consumo esta dado en litros por hora.
			double consumo=modelo1.getConsumo();
			double velocidad=modelo1.getVelocidad();
			double duracionHoras=distancia/velocidad;
			double costoViaje=consumo*duracionHoras*simulador.getPrecioKerosene();
			double litrosConsumidos=consumo*duracionHoras;
			// Vamos a poner un precio de, digamos, 100 dolares por hora de vuelo.
			double precioPorHora=100.0;
			double precioPasaje=duracionHoras*precioPorHora;
			double ventaTotal=modelo1.getCapacidad()*precioPasaje;
			double gananciaTotal=ventaTotal-costoViaje;
			System.out.println("El viaje costara "+costoViaje+" dolares");
			System.out.println("Se consumiran "+litrosConsumidos+" de kerosene");
			System.out.println("El pasajero pagaria "+precioPasaje+" dolares su pasaje y viajarian "+modelo1.getCapacidad()+" pasajeros");
			System.out.println("El viaje cobraria "+ventaTotal+" dolares");
			System.out.println("La ganancia de este viaje seria "+gananciaTotal+" dolares");
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
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
