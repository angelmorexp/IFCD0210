import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Acceso extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnAceptar;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceso frame = new Acceso();
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
	public Acceso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 187);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Acceso");
		
		JLabel lblUsuario = new JLabel("Usuario (admin)");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(10, 11, 112, 17);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(10, 35, 168, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("Contrase�a (admin123)");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(10, 77, 168, 17);
		contentPane.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 255));{
		passwordField.setBounds(10, 100, 168, 21);
		contentPane.add(passwordField);
		
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setForeground(new Color(255, 240, 245));
		btnAceptar.setBackground(new Color(219, 112, 147));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String usuario = textField.getText();
				char clave[] = passwordField.getPassword();
				String contrase�a= new String(clave);
				if (usuario.equals("admin")&& contrase�a.equals("admin123")) {
					
					setVisible(false);  //ESCONDER EL LOGIN
					
					Formulario nw = new Formulario(); //MOSTRAR EL FORMULARIO
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Usuario o Contrase�a Inv�lidos"); //MOSTRAR QUE EL USUARIO O LA CONTRASE�A ES ERRONEA
				}
			}
		});
		btnAceptar.setBounds(208, 35, 89, 87);
		contentPane.add(btnAceptar);
		
		}
	}
}
