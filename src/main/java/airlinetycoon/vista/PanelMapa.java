package airlinetycoon.vista;

import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.FeatureLayer;
import org.geotools.map.Layer;
import org.geotools.map.MapContent;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;
import org.geotools.swing.JMapPane;

public class PanelMapa extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5205130769403365827L;

	public PanelMapa()
	{
		inicializarMapa();
	}
	private void inicializarMapa()
	{
	}
}
