package airlinetycoon.vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import airlinetycoon.modelo.CambiosDineroObserver;
import airlinetycoon.modelo.EventosRelojObserver;
import airlinetycoon.modelo.Reloj;

public class PanelEstado extends JPanel implements EventosRelojObserver,ActionListener,
CambiosDineroObserver
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6356562904435589549L;
	private FrameAirlineTycoon f;
	private JTextField campoFecha;
	private JButton botonComenzar;
	private JButton botonParar;
	private JTextField campoDinero;

	public PanelEstado(FrameAirlineTycoon frame)
	{
		this.f=frame;
		initComponents();
	}
	private void initComponents()
	{
		// Estado de la simulacion.
		// Filas, columnas
		GridLayout g=new GridLayout(3,2);
		this.setLayout(g);
		JLabel tituloFecha=new JLabel();
		tituloFecha.setText("Fecha");
		this.add(tituloFecha);
		campoFecha=new JTextField();
		this.add(campoFecha);
		// Plata, plata, PLATA!!!!
		JLabel tituloDinero=new JLabel();
		tituloDinero.setText("Dinero");
		campoDinero=new JTextField();
		this.add(campoDinero);
		Reloj.getInstance().agregarReceptorHora(this);
		botonComenzar=new JButton();
		botonComenzar.setText("Comenzar Reloj");
		botonComenzar.addActionListener(this);
		this.add(botonComenzar);
		botonParar=new JButton();
		botonParar.setText("Parar Reloj");
		botonParar.addActionListener(this);
		this.add(botonParar);
	}
	@Override
	public void nuevaHora(Date hora)
	{
		campoFecha.setText(hora.toString());
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent evento)
	{
		if(evento.getSource()==botonComenzar)
		{
			f.iniciarSimulacion();
		}
		if(evento.getSource()==botonParar)
		{
			f.pararSimulacion();
		}
	}
	@Override
	public void nuevoDinero(BigDecimal dinero)
	{
		campoDinero.setText(dinero.toString());
		repaint();
	}
}
