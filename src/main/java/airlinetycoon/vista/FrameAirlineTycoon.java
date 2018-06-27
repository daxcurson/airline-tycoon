package airlinetycoon.vista;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import airlinetycoon.modelo.Configurador;
import airlinetycoon.modelo.Simulador;

public class FrameAirlineTycoon extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2207672880325147461L;
	
	private Simulador simulador;
	private PanelMapa panelMapa;
	
	public FrameAirlineTycoon()
	{
		// Leemos la configuracion del archivo de configuracion.
		try
		{
			Configurador.getInstance().LeerConfiguracion();
			initComponents();
			cargarSimulacion();
		}
		catch(IOException e)
		{
			System.out.println("Imposible abrir el archivo de configuracion. Error de lectura. La aplicacion se cerrara.");
			System.exit(1);
		}
		catch(NullPointerException e)
		{
			System.out.println("No existe el archivo de configuracion. Por favor creelo.");
			e.printStackTrace();
			System.exit(1);
		}
	}
	private void cargarSimulacion()
	{
		simulador=Simulador.getInstance();
		simulador.agregarCiudadObserver(panelMapa);
		simulador.cargarDatosIniciales();
	}
	private void initComponents()
	{
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(960,700);
		GridLayout g=new GridLayout(2,1);
		this.setLayout(g);
		panelMapa=new PanelMapa();
		this.add(panelMapa);
		PanelEstado panelEstado=new PanelEstado(this);
		this.add(panelEstado);
	}
	public static void main(String[] args) 
	{
		FrameAirlineTycoon f=new FrameAirlineTycoon();
		f.setVisible(true);
	}
	public void salir()
	{
		System.exit(0);
	}
}

