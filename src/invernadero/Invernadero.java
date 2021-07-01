package invernadero;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;



public class Invernadero {

	private JFrame frame;
	private JTextField textSerial;
	private JTextField textNombre;
	private JTextField textOrden;
	private JTextField textFamilia;
	private JTextField textGenero;
	private JTable table;
	
	void refrescar() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Serial");
		modelo.addColumn("Nombre");
		modelo.addColumn("Grupo");
		modelo.addColumn("Orden");
		modelo.addColumn("Familia");
		modelo.addColumn("Género");
		modelo.addColumn("Cantidad");
		table.setModel(modelo);
		String datos[] = new String[7];
		Statement at = null;
		String url = "jdbc:postgresql://localhost:5432/Invernadero";
		try {
			Connection base = DriverManager.getConnection(url, "postgres", "tomas");
			at = base.createStatement();
			ResultSet rs = at.executeQuery("SELECT * FROM Invernadero");
			while (rs.next()) {
				datos[0] = rs.getString("serial");
				datos[1] = rs.getString("nombre");
				datos[2] = rs.getString("grupo");
				datos[3] = rs.getString("orden");
				datos[4] = rs.getString("familia");
				datos[5] = rs.getString("genero");
				datos[6] = rs.getString("cantidad");
				modelo.addRow(datos);
			}
			JOptionPane.showMessageDialog(null, "Acepta para continuar");
			rs.close();
			at.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invernadero window = new Invernadero();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Invernadero() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 782, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Invernadero 2.0");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 756, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Realizado por Tom\u00E1s Villasmil / Programaci\u00F3n Orientada a Objetos");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 32, 756, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Serial");
		lblNewLabel_2.setBounds(10, 74, 60, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setBounds(10, 99, 60, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Grupo");
		lblNewLabel_4.setBounds(10, 124, 60, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Orden");
		lblNewLabel_5.setBounds(10, 149, 60, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Familia");
		lblNewLabel_6.setBounds(10, 174, 60, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("G\u00E9nero");
		lblNewLabel_7.setBounds(10, 199, 60, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		textSerial = new JTextField();
		textSerial.setBounds(70, 71, 86, 20);
		frame.getContentPane().add(textSerial);
		textSerial.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(70, 96, 86, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textOrden = new JTextField();
		textOrden.setBounds(70, 146, 86, 20);
		frame.getContentPane().add(textOrden);
		textOrden.setColumns(10);
		
		textFamilia = new JTextField();
		textFamilia.setBounds(70, 171, 86, 20);
		frame.getContentPane().add(textFamilia);
		textFamilia.setColumns(10);
		
		textGenero = new JTextField();
		textGenero.setBounds(70, 196, 86, 20);
		frame.getContentPane().add(textGenero);
		textGenero.setColumns(10);
		
		JLabel lblNewLabel_7_1 = new JLabel("Cantidad");
		lblNewLabel_7_1.setBounds(10, 224, 60, 14);
		frame.getContentPane().add(lblNewLabel_7_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Espermatofita", "Pteridofita"}));
		comboBox.setBounds(70, 120, 86, 22);
		frame.getContentPane().add(comboBox);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(70, 221, 86, 20);
		frame.getContentPane().add(spinner);

		table = new JTable();
		
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setEnabled(false);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setBounds(166, 89, 585, 287);
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				String urlDatabase = "jdbc:postgresql://localhost:5432/Invernadero";
				try {
					Class.forName("org.postgresql.Driver");
					con = DriverManager.getConnection(urlDatabase, "postgres", "tomas");
					Statement st = con.createStatement();
					String sql = "INSERT INTO Invernadero(serial, nombre, grupo, orden, familia, genero, cantidad)"
							+ "values ('" + textSerial.getText() + "', '" + textNombre.getText() + "', '" + comboBox.getSelectedItem() + "', '" + textOrden.getText() + "', '" + textFamilia.getText() + "', '" + textGenero.getText() + "', '" + spinner.getValue() + "')";
					
					ResultSet result = st.executeQuery(sql);
					con.close();
					st.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				refrescar();

			}
				
		});
		btnNewButton.setBounds(10, 249, 146, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				String urlDatabase = "jdbc:postgresql://localhost:5432/Invernadero";
				try {
					Class.forName("org.postgresql.Driver");
					con = DriverManager.getConnection(urlDatabase, "postgres", "tomas");
					Statement st = con.createStatement();
					String sql = "UPDATE Invernadero SET"
							+ " serial='" + textSerial.getText() + "', nombre='" + textNombre.getText() + "', grupo='" + comboBox.getSelectedItem() + "', orden='" + textOrden.getText() + "', familia='" + textFamilia.getText() + "', genero='" + textGenero.getText() + "', cantidad='" + spinner.getValue() + "' WHERE serial='" + textSerial.getText() + "'";
					
					ResultSet result = st.executeQuery(sql);
					con.close();
					st.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				refrescar();
			}
		});
		btnModificar.setBounds(10, 275, 146, 23);
		frame.getContentPane().add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				String urlDatabase = "jdbc:postgresql://localhost:5432/Invernadero";
				try {
					Class.forName("org.postgresql.Driver");
					con = DriverManager.getConnection(urlDatabase, "postgres", "tomas");
					Statement st = con.createStatement();
					String sql = "DELETE FROM Invernadero WHERE serial='" + textSerial.getText() + "'";
					ResultSet result = st.executeQuery(sql);
					con.close();
					st.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				refrescar();
			}
		});
		btnEliminar.setBounds(10, 301, 146, 23);
		frame.getContentPane().add(btnEliminar);
		
		JButton btnModificar_1_1 = new JButton("Refrescar");
		btnModificar_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrescar();
			}
		});
		btnModificar_1_1.setBounds(10, 327, 146, 23);
		frame.getContentPane().add(btnModificar_1_1);
		
		JButton btnModificar_1_1_1 = new JButton("Nuevo");
		btnModificar_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textSerial.setText("");
				textNombre.setText("");
				comboBox.setSelectedItem(null);
				textOrden.setText("");
				textFamilia.setText("");
				textGenero.setText("");
				spinner.setValue(0);
			}
		});
		btnModificar_1_1_1.setBounds(10, 353, 146, 23);
		frame.getContentPane().add(btnModificar_1_1_1);
		
		JLabel lblNewLabel_8 = new JLabel("Serial");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(166, 74, 86, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("Nombre");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8_1.setBounds(249, 74, 86, 14);
		frame.getContentPane().add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_2 = new JLabel("Grupo");
		lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8_2.setBounds(333, 74, 86, 14);
		frame.getContentPane().add(lblNewLabel_8_2);
		
		JLabel lblNewLabel_8_3 = new JLabel("Orden");
		lblNewLabel_8_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8_3.setBounds(415, 74, 86, 14);
		frame.getContentPane().add(lblNewLabel_8_3);
		
		JLabel lblNewLabel_8_4 = new JLabel("Familia");
		lblNewLabel_8_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8_4.setBounds(499, 74, 86, 14);
		frame.getContentPane().add(lblNewLabel_8_4);
		
		JLabel lblNewLabel_8_5 = new JLabel("G\u00E9nero");
		lblNewLabel_8_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8_5.setBounds(581, 74, 86, 14);
		frame.getContentPane().add(lblNewLabel_8_5);
		
		JLabel lblNewLabel_8_6 = new JLabel("Cantidad");
		lblNewLabel_8_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8_6.setBounds(665, 74, 86, 14);
		frame.getContentPane().add(lblNewLabel_8_6);

	}
}
