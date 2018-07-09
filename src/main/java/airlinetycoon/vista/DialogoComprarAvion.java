package airlinetycoon.vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import airlinetycoon.modelo.Modeloavion;

public class DialogoComprarAvion extends JDialog implements ActionListener
{
	private JButton comprar;
	private JButton cancelar;
	private JTable table;
	private List<Modeloavion> modelos;
	/**
	 * 
	 */
	private static final long serialVersionUID = 5124318716817951655L;

	public DialogoComprarAvion(List<Modeloavion> modelos)
	{
		JPanel panelBotones = new JPanel();
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
		comprar=new JButton();
		comprar.setText("Comprar");
		comprar.addActionListener(this);
		panelBotones.add(comprar);
		cancelar=new JButton();
		cancelar.setText("Cancelar");
		cancelar.addActionListener(this);
		panelBotones.add(cancelar);
		
		JPanel panelLista = new JPanel();
		getContentPane().add(panelLista, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelLista.add(table);
		this.modelos=modelos;
	}
	public boolean mostrar()
	{
		boolean grabamos=false;
		// Recorro la lista de aviones
		DefaultTableModel model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Modelo","Autonomia (km)","Consumo (l/h)","Velocidad (km/h)","Capacidad (pasajeros)"
				}
				);
		table.setModel(model);
		for(Modeloavion avion:modelos)
		{
			Object[] datos=new Object[7];
			datos[0]=avion;
			datos[1]=avion.getModelo();
			datos[2]=avion.getAutonomia();
			datos[3]=avion.getConsumo();
			datos[4]=avion.getVelocidad();
			datos[5]=avion.getCapacidad();
			model.addRow(datos);
		}
		setModal(true);
		setVisible(true);
		return grabamos;
	}
	@Override
	public void actionPerformed(ActionEvent evento)
	{
	}
}
