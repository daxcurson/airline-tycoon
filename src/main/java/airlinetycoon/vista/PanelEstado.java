package airlinetycoon.vista;

import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import airlinetycoon.modelo.EventosRelojObserver;
import airlinetycoon.modelo.Reloj;

public class PanelEstado extends JPanel implements EventosRelojObserver
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6356562904435589549L;
	private FrameAirlineTycoon f;
	private JTextField campoFecha;

	public PanelEstado(FrameAirlineTycoon frame)
	{
		this.f=frame;
		initComponents();
	}
	private void initComponents()
	{
		// Estado de la simulacion.
		// Filas, columnas
		GridLayout g=new GridLayout(1,2);
		this.setLayout(g);
		JLabel tituloFecha=new JLabel();
		tituloFecha.setText("Fecha");
		this.add(tituloFecha);
		campoFecha=new JTextField();
		this.add(campoFecha);
		Reloj.getInstance().agregarReceptorHora(this);
	}
	@Override
	public void nuevaHora(Date hora)
	{
		campoFecha.setText(hora.toString());
		repaint();
	}
}
