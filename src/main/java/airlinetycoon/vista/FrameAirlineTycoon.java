package airlinetycoon.vista;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.WindowConstants;

import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.FeatureLayer;
import org.geotools.map.Layer;
import org.geotools.map.MapContent;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;
import org.geotools.swing.JMapFrame;

import airlinetycoon.modelo.Configurador;

public class FrameAirlineTycoon extends JMapFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2207672880325147461L;
	public FrameAirlineTycoon()
	{
		super();
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
	public void initComponents()
	{
		super.initComponents();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(960,700);
		GridLayout g=new GridLayout(2,1);
		this.setLayout(g);
		PanelEstado panelEstado=new PanelEstado();
		this.add(panelEstado);
		FileDataStore store;
		try {
			store = FileDataStoreFinder.getDataStore(getClass().getClassLoader().getResource("geo-data/ne_50m_admin_0_sovereignty.shp"));
		SimpleFeatureSource featureSource=store.getFeatureSource();
		MapContent map=new MapContent();
		map.setTitle("Test");
		Style style=SLD.createSimpleStyle(featureSource.getSchema());
		Layer layer=new FeatureLayer(featureSource,style);
		map.addLayer(layer);
		JMapFrame.showMap(map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

