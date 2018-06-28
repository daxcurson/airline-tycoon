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

import airlinetycoon.modelo.CambiosCiudadObserver;
import airlinetycoon.modelo.Ciudad;

public class PanelMapa extends JPanel implements CambiosCiudadObserver
{
	private BufferedImage mapa;
	private LinkedList<Ciudad> ciudades;

	/**
	 * 
	 */
	private static final long serialVersionUID = -5205130769403365827L;

	public PanelMapa()
	{
		cargarMapa();
		initComponents();
	}
	public void cargarMapa()
	{
		URL url = ClassLoader.getSystemResource("mapa.jpg");
		try
		{
			mapa=ImageIO.read(url);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void initComponents()
	{
		
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
	}
	@Override
	public void agregarCiudad(Ciudad c)
	{
		ciudades.add(c);
		repaint();
	}
}
