package airlinetycoon.modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * El todopoderoso reloj de la simulacion
 * @author Agustín Villafañe
 *
 */
public class Reloj
{
	private static Reloj instance;

	private ScheduledExecutorService servicioEjecutor;
	
	/**
	 * Los segundos simulados desde el inicio de la simulacion
	 */
	private long segundosSimulados;
	/**
	 * A que hora se inicio esta simulacion.
	 */
	private Date horaInicial;
	/**
	 * velocidad del paso de los segundos: que tanto mas rapido que en la realidad
	 * transcurren los segundos en mi sistema.
	 */
	private long velocidadSegundos;
	/**
	 * Lista de observadores del reloj
	 */
	private List<EventosRelojObserver> observadoresReloj;
	class TareaReloj implements Runnable
	{

		@Override
		public void run()
		{
			segundosSimulados+=velocidadSegundos;
		}
	}
	
	class TareaAvisadora implements Runnable
	{
		@Override
		public void run()
		{
			for(EventosRelojObserver o:observadoresReloj)
			{
				
			}
		}
	}
	private Reloj()
	{
		servicioEjecutor=Executors.newScheduledThreadPool(5);
		observadoresReloj=new LinkedList<EventosRelojObserver>();
		// Ponemos en marcha el reloj.
		segundosSimulados=0;
		// La velocidad tendria que poder ser elegida por el usuario, por ahora
		// la vamos a hard-codear.
		velocidadSegundos=3;
		TareaReloj reloj=new TareaReloj();
		servicioEjecutor.scheduleAtFixedRate(reloj, 0, 1, TimeUnit.SECONDS);
	}
	public static Reloj getInstance()
	{
		if(instance==null)
			instance=new Reloj();
		return instance;
	}
	/**
	 * Da la hora simulada del momento en que se pide, calculada como la cantidad
	 * de segundos simulados que transcurrieron desde la fecha inicial.
	 * @return
	 */
	public Date horaSimulada()
	{
		Calendar c=Calendar.getInstance();
		c.setTimeInMillis(this.horaInicial.getTime()+this.segundosSimulados*1000);
		return c.getTime();
	}
}
