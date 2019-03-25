import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;



public class Formulario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtNoIndicado;
	private JTextField txtNoIndicado_1;

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
		Border border = BorderFactory.createLineBorder(Color.black, 1);
		contentPane =new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(border);

		//Indicamos su diseño
		contentPane.setLayout(null);

		//asigno el pannel a la ventana
		setContentPane(contentPane);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(20, 22, 121, 22);
		contentPane.add(lblNombre);

		txtNoIndicado = new JTextField();
		txtNoIndicado.setText("No indicado");
		txtNoIndicado.setBounds(20, 44, 121, 22);
		contentPane.add(txtNoIndicado);
		txtNoIndicado.setColumns(10);

		JLabel label = new JLabel("Apellidos");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(20, 71, 121, 22);
		contentPane.add(label);

		txtNoIndicado_1 = new JTextField();
		txtNoIndicado_1.setText("No indicado");
		txtNoIndicado_1.setColumns(10);
		txtNoIndicado_1.setBounds(20, 96, 121, 22);
		contentPane.add(txtNoIndicado_1);
		
		JLabel label_1 = new JLabel("Edad");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(164, 129, 58, 22);
		contentPane.add(label_1);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 200, 1));
		spinner.setBounds(164, 158, 70, 22);
		contentPane.add(spinner);

		JLabel label_2 = new JLabel("Género");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(164, 22, 58, 22);
		contentPane.add(label_2);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hombre");
		rdbtnNewRadioButton.setBackground(new Color(255, 240, 245));
		rdbtnNewRadioButton.setBounds(164, 70, 109, 23);
		contentPane.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Mujer");
		rdbtnNewRadioButton_1.setBackground(new Color(255, 240, 245));
		rdbtnNewRadioButton_1.setBounds(164, 44, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("No Binario");
		rdbtnNewRadioButton_2.setBackground(new Color(255, 240, 245));
		rdbtnNewRadioButton_2.setBounds(164, 96, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);

		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(rdbtnNewRadioButton);
		bgroup.add(rdbtnNewRadioButton_1);
		bgroup.add(rdbtnNewRadioButton_2);
		
		JLabel label_3 = new JLabel("Ocupación");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(20, 129, 121, 22);
		contentPane.add(label_3);

		ButtonGroup bgroup1 = new ButtonGroup();

		JCheckBox chckbxEstudiante = new JCheckBox("Estudiante");
		chckbxEstudiante.setBackground(new Color(255, 240, 245));
		chckbxEstudiante.setBounds(20, 158, 97, 23);
		contentPane.add(chckbxEstudiante);

		JCheckBox chckbxTrabajador = new JCheckBox("Trabajador");
		chckbxTrabajador.setBackground(new Color(255, 240, 245));
		chckbxTrabajador.setBounds(20, 184, 97, 23);
		contentPane.add(chckbxTrabajador);
		
		JLabel lblOtrosDatosDe = new JLabel("Otros datos de Inter\u00E9s");
		lblOtrosDatosDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOtrosDatosDe.setBounds(279, 26, 183, 14);
		contentPane.add(lblOtrosDatosDe);

		JTextArea textArea = new JTextArea();
		
		textArea.setBorder(border);
		textArea.setForeground(new Color(219, 112, 147));
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(279, 51, 238, 156);
		contentPane.add(textArea);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEnviar.setBackground(new Color(219, 112, 147));
		btnEnviar.setForeground(new Color(255, 240, 245));
		btnEnviar.setBorder(border);
		btnEnviar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				   String nombre= txtNoIndicado.getText();
				   String apellido= txtNoIndicado_1.getText();
				   Integer edad= (Integer)spinner.getValue();
				   String genero = null;
					if (rdbtnNewRadioButton.isSelected()) { 
						genero = "Hombre";
					} else if (rdbtnNewRadioButton_1.isSelected()){
						genero = "Mujer";
					} else if (rdbtnNewRadioButton_2.isSelected()) {
						genero = "No binario";
					} else {
						genero = "No indicado";
					}
					String ocupacion = null;
					
					if (chckbxTrabajador.isSelected() && chckbxEstudiante.isSelected()) {
						ocupacion= "Estudiante y Trabajador";
					}else if (chckbxEstudiante.isSelected()) {
						ocupacion= "Estudiante";
					}else if (chckbxTrabajador.isSelected()) {
						ocupacion= "Trabajador";
					}else {
						ocupacion= "Ni estudio ni trabajo";
					}
					String datos= textArea.getText();
					String mensaje= " Nombre: "+nombre+"\n Apellidos: "+apellido+"\n Edad: "+edad+"\n Genero: "+genero+"\n Ocupación: "+ocupacion+"\n Otros datos: "+datos;
					PrintWriter writer = null;
					
					try {
						boolean exists= true;
						int contador = 0;
						
						while (exists) {			//BUCLE QUE COMPRUEBA LA EXISTENCIA DEL NOMBRE DEL DOCUMENTO, SI NO EXISTE, SE TERMINA EL BUCLE
							contador++;
							File tempFile = new File("C:/Users/aula1/eclipse-workspace/E2.2/usuario_"+contador+".txt");		//VARIABLE DEL NOMBRE DEL ARCHIVO
							exists = tempFile.exists();					//COMPRUEBA ARCHIVO EXISTENTE
						}
						String documento= "usuario_"+contador+".txt";	//NOMBRE DEL DOCUMENTO NUEVO
						
						writer = new PrintWriter(documento, "UTF-8");	//CREAR UN ARCHIVO .TXT CON LOS DATOS DE USUARIO
						JOptionPane.showMessageDialog(null, "Sus datos han sido registrados satisfactoriamente en el fichero: "+documento);
					}
					catch (FileNotFoundException | UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			   }
			   
			});
		btnEnviar.setBounds(229, 238, 89, 23);
		contentPane.add(btnEnviar);


	}
}
