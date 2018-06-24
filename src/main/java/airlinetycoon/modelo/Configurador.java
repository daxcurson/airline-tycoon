package airlinetycoon.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Configurador. Busca en el archivo de propiedades los datos de c�mo configurar el programa,
 * por ejemplo de d�nde tiene que leer los datos de los vuelos (archivos o base de datos)
 * @author avillafa
 *
 */
public class Configurador
{
	private static Configurador instance;
	private String archivoConfiguracion;
	private String repositorio;
	
	private Configurador()
	{
		archivoConfiguracion=new String();
		archivoConfiguracion="configuration.properties";
	}
	public static Configurador getInstance()
	{
		if(instance==null)
			instance=new Configurador();
		return instance;
	}
	public void LeerConfiguracion() throws IOException, NullPointerException
	{
		// Leo la configuraci�n.
		Properties properties=new Properties();
		
		InputStream is=this.getClass().getClassLoader().getResourceAsStream(archivoConfiguracion); //.getSystemResourceAsStream(archivoConfiguracion);
		properties.load(is);
		repositorio=properties.getProperty("repositorio");
	}
	public Object DarRepositorio(String clase) throws ClassNotFoundException,InstantiationException,IllegalAccessException
	{
		// Averiguo de qu� me est�n pidiendo la clase y creo un Dao seg�n el repositorio configurado.
		Class<?> c=Class.forName("datos."+repositorio.toLowerCase()+"."+clase+"Dao"+repositorio);
		return c.newInstance();
	}
}
