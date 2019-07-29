package airlinetycoon.simulador;

import java.util.LinkedList;
import java.util.List;

import airlinetycoon.modelo.Ciudad;

public class Simulador 
{
	private static Simulador me;
	private List<Ciudad> ciudades;
	private AgenciaViajes agencia;
	
	private Simulador()
	{
		setCiudades(new LinkedList<Ciudad>());
		setAgencia(new AgenciaViajes());
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
}
