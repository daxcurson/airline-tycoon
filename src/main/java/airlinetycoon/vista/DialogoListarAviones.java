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

import airlinetycoon.modelo.Avion;

public class DialogoListarAviones extends JDialog implements ActionListener
{
	private JTable table;
	private JButton agenda;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8234939534004333726L;

	public DialogoListarAviones() 
	{
		JPanel panelBotones = new JPanel();
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
		agenda=new JButton();
		agenda.setText("Agenda...");
		agenda.addActionListener(this);
		panelBotones.add(agenda);
		
		JPanel panelLista = new JPanel();
		getContentPane().add(panelLista, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelLista.add(table);
	}
	public boolean mostrar(List<Avion> listaAviones)
	{
		boolean grabamos=false;
		// Recorro la lista de aviones
		DefaultTableModel model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nombre Avion", "Modelo","Kilometros recorridos"
				}
				);
		table.setModel(model);
		for(Avion avion:listaAviones)
		{
			Object[] datos=new Object[4];
			datos[0]=avion;
			datos[1]=avion.getModeloId();
			datos[2]=avion.getUbicacion();
			datos[3]=avion.getKilometros_recorridos();
			model.addRow(datos);
		}
		setModal(true);
		setVisible(true);
		return grabamos;
	}
	@Override
	public void actionPerformed(ActionEvent evento)
	{
		if(evento.getSource()==agenda)
		{
			// Mostrar la agenda del avion.
		}
	}
}
