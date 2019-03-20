import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;



public class Formulario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	 public Formulario() {
	        //Añade un titulo, no es estrictamente necesario
	                setTitle("Formulario");
	 
	                /*
	                 * Coordenadas x y de la aplicacion y su altura y longitud,
	                 * si no lo indicamos aparecera una ventana muy pequeña
	                 */
	                setBounds(400, 200, 564, 311);
	 
	                /*
	                 * Indica que cuando se cierre la ventana se acaba la aplicacion,
	                 * si no lo indicamos cuando cerremos la ventana la aplicacion seguira funcionando
	                 */
	                setDefaultCloseOperation(EXIT_ON_CLOSE);
	 
	                //Hace visible la ventana, si no lo hacemos no veremos la aplicacion
	                setVisible(true);
	 
	                //Creamos el panel
	                contentPane =new JPanel();
	 
	                //Indicamos su diseño
	                contentPane.setLayout(null);
	 
	                //asigno el pannel a la ventana
	                setContentPane(contentPane);
	                
	                JLabel lblNombre = new JLabel("Nombre");
	                lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
	                lblNombre.setBounds(20, 22, 58, 22);
	                contentPane.add(lblNombre);
	                
	                textField_2 = new JTextField();
	                textField_2.setBounds(20, 44, 121, 22);
	                contentPane.add(textField_2);
	                textField_2.setColumns(10);
	                
	                JLabel label = new JLabel("Apellidos");
	                label.setFont(new Font("Tahoma", Font.PLAIN, 14));
	                label.setBounds(20, 71, 58, 22);
	                contentPane.add(label);
	                
	                textField_3 = new JTextField();
	                textField_3.setColumns(10);
	                textField_3.setBounds(20, 96, 121, 22);
	                contentPane.add(textField_3);
	                
	                JLabel label_1 = new JLabel("Edad");
	                label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	                label_1.setBounds(164, 129, 58, 22);
	                contentPane.add(label_1);
	                
	                JSpinner spinner = new JSpinner();
	                spinner.setModel(new SpinnerNumberModel(0, 0, 200, 1));
	                spinner.setBounds(164, 158, 70, 22);
	                contentPane.add(spinner);
	                
	                JLabel label_2 = new JLabel("Género");
	                label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	                label_2.setBounds(164, 22, 58, 22);
	                contentPane.add(label_2);
	                
	                
	                
	                JRadioButton rdbtnNewRadioButton = new JRadioButton("Hombre");
	                rdbtnNewRadioButton.setBounds(164, 70, 109, 23);
	                contentPane.add(rdbtnNewRadioButton);
	                
	                JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Mujer");
	                rdbtnNewRadioButton_1.setBounds(164, 44, 109, 23);
	                contentPane.add(rdbtnNewRadioButton_1);
	                
	                JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("No Binario");
	                rdbtnNewRadioButton_2.setBounds(164, 96, 109, 23);
	                contentPane.add(rdbtnNewRadioButton_2);
	                
	                ButtonGroup bgroup = new ButtonGroup();
	                bgroup.add(rdbtnNewRadioButton);
	                bgroup.add(rdbtnNewRadioButton_1);
	                bgroup.add(rdbtnNewRadioButton_2);
	             
	                JLabel label_3 = new JLabel("Ocupación");
	                label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
	                label_3.setBounds(20, 129, 121, 22);
	                contentPane.add(label_3);
	                
	                ButtonGroup bgroup1 = new ButtonGroup();
	                
	                JCheckBox chckbxEstudiante = new JCheckBox("Estudiante");
	                chckbxEstudiante.setBounds(20, 158, 97, 23);
	                contentPane.add(chckbxEstudiante);
	                
	                JCheckBox chckbxTrabajador = new JCheckBox("Trabajador");
	                chckbxTrabajador.setBounds(20, 184, 97, 23);
	                contentPane.add(chckbxTrabajador);
	                
	                JLabel lblOtrosDatosDe = new JLabel("Otros datos de Inter\u00E9s");
	                lblOtrosDatosDe.setFont(new Font("Tahoma", Font.PLAIN, 14));
	                lblOtrosDatosDe.setBounds(279, 26, 183, 14);
	                contentPane.add(lblOtrosDatosDe);
	                
	                JTextArea textArea = new JTextArea();
	                textArea.setBackground(Color.WHITE);
	                textArea.setBounds(279, 51, 238, 156);
	                contentPane.add(textArea);
	                
	                JButton btnEnviar = new JButton("Enviar");
	                btnEnviar.setBounds(229, 238, 89, 23);
	                contentPane.add(btnEnviar);
	                
	            
	    }
	}
