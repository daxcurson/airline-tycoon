package airlinetycoon.vista;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import airlinetycoon.modelo.Configurador;

public class FrameAirlineTycoon extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2207672880325147461L;
	public FrameAirlineTycoon()
	{
		// Leemos la configuracion del archivo de configuracion.
		try
		{
			Configurador.getInstance().LeerConfiguracion();
			initComponents();
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
	private void initComponents()
	{
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(960,700);
		GridLayout g=new GridLayout(2,1);
		this.setLayout(g);
		PanelEstado panelEstado=new PanelEstado();
		this.add(panelEstado);
		PanelMapa panelMapa=new PanelMapa();
		this.add(panelMapa);
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

