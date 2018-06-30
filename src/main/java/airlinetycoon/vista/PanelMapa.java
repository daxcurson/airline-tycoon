package airlinetycoon.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import airlinetycoon.modelo.Avion;
import airlinetycoon.modelo.CambiosAvionObserver;
import airlinetycoon.modelo.CambiosCiudadObserver;
import airlinetycoon.modelo.Ciudad;
import airlinetycoon.modelo.Posicion;

public class PanelMapa extends JPanel implements CambiosCiudadObserver,CambiosAvionObserver
{
	private BufferedImage mapa;
	private BufferedImage avion;
	private LinkedList<Ciudad> ciudades;
	private LinkedList<Avion> aviones;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5205130769403365827L;

	public PanelMapa()
	{
		cargarImagenes();
		initComponents();
	}
	public void cargarImagenes()
	{
		URL urlmapa = ClassLoader.getSystemResource("mapa.jpg");
		URL urlavion=ClassLoader.getSystemResource("avion.gif");
		try
		{
			mapa=ImageIO.read(urlmapa);
			avion=ImageIO.read(urlavion);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void initComponents()
	{
		ciudades=new LinkedList<Ciudad>();
		aviones=new LinkedList<Avion>();
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(mapa,0,0,this);
		// Dibujamos la lista de ciudades.
		for(Ciudad c:ciudades)
		{
			int Xciudad=(int)( c.getLongitud()*(mapa.getWidth()/2)/180+mapa.getWidth()/2);
			int Yciudad=(int)( mapa.getHeight()/2-c.getLatitud()*(mapa.getHeight()/2)/90 );
			g2.setColor(Color.red);
			g2.fillOval(Xciudad-3, Yciudad-3, 6, 6);
			g2.setColor(Color.black);
			g2.drawOval(Xciudad-3, Yciudad-3, 6, 6);
		}
		// Dibujamos los aviones.
		for(Avion a:aviones)
		{
			// El dibujito del avion tiene que estar centrado.
			Posicion posicion=a.getPosicion();
			int Xavion=(int)(posicion.getLongitud()*(avion.getWidth()/2)/180+avion.getWidth()/2);
			int Yavion=(int)(avion.getHeight()/2-posicion.getLatitud()*(avion.getHeight()/2)/90);
			g2.drawImage(avion, Xavion, Yavion, avion.getWidth(), avion.getHeight(), this);
		}
	}
	@Override
	public void agregarCiudad(Ciudad c)
	{
		ciudades.add(c);
		repaint();
	}
	@Override
	public void agregarAvion(Avion avion)
	{
		aviones.add(avion);
		repaint();
	}
}
