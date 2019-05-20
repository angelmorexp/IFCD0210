package Sockets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		marcocliente mimarco = new marcocliente();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class marcocliente extends JFrame {

	public marcocliente() {
		
		setBounds(300, 300, 300, 300);
		panelcliente contenido = new panelcliente();
		add(contenido);
		setVisible(true);
		addWindowListener(new envioonline());
	}
}

class envioonline extends WindowAdapter {
	public void windowOpened(WindowEvent e) {
		try {
			Socket misocket = new Socket("192.168.1.175",7070);
			paqueteenvio primer = new paqueteenvio();
			primer.setMensaje("online");
			ObjectOutputStream paquetedatos = new ObjectOutputStream(misocket.getOutputStream());
			paquetedatos.writeObject(primer);
			misocket.close();
		}
		catch(Exception e2){}
	}
}
		
class panelcliente extends JPanel implements Runnable {
	
	public panelcliente() {
		String nick_usuario = JOptionPane.showInputDialog("Nick: ");
		JLabel nnick = new JLabel("Nick: ");
		add(nnick);
		nick = new JLabel();
		nick.setText(nick_usuario);
		add(nick);
		JLabel titulo = new JLabel("Online: ");
		add(titulo);
		ip = new JComboBox();
		add(ip);
		campochat = new JTextArea(10,24);
		campochat.setEditable(false);
		add(campochat);
		texto = new JTextField(24);
		add(texto);
		enviar = new JButton("Enviar");
		enviatexto mievento = new enviatexto();
		enviar.addActionListener(mievento);
		add(enviar);
		
		Thread mihilo = new Thread(this);
		mihilo.start();
	}
	
	private class enviatexto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			campochat.append("\n"+"Yo: " + texto.getText());
			
			try {
				
				Socket misocket = new Socket("192.168.1.175", 7070);
				
				paqueteenvio mienvio = new paqueteenvio();
				
				mienvio.setNick(nick.getText());
				mienvio.setIp(ip.getSelectedItem().toString());
				mienvio.setMensaje(texto.getText());
				
				ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());
				paquete_datos.writeObject(mienvio);
				misocket.close();
				
				texto.setText("");

				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				texto.setText("");
				System.out.println("Error de conexión");
			}
		}
	}
	private JTextField texto;
	private JComboBox ip;
	private JLabel nick;
	private JTextArea campochat;
	private JButton enviar; 
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ServerSocket servidor_cliente = new ServerSocket(9090);
			Socket cliente;
			paqueteenvio paquete_recibido;
			
			while (true) {
				
				cliente= servidor_cliente.accept();
				ObjectInputStream flujoentrada = new ObjectInputStream(cliente.getInputStream());
				paquete_recibido= (paqueteenvio) flujoentrada.readObject();
				
				if(!paquete_recibido.getMensaje().equals("online")) {
					
					campochat.append("\n"+paquete_recibido.getNick()+ ": "+paquete_recibido.getMensaje());
					
				}else {
					
					ArrayList<String> ipmenu = new ArrayList<String>();
					ipmenu = paquete_recibido.getIps();
					ip.removeAllItems();
					for (String z:ipmenu) {
						ip.addItem(z);
					}
				}
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


class paqueteenvio implements Serializable {
	
	public ArrayList<String> getIps() {
		return ips;
	}

	public void setIps(ArrayList<String> ips) {
		this.ips = ips;
	}

	private String nick, ip, mensaje;
	
	private ArrayList<String> ips;
	
	public String getNick() {
		return nick;
	}

	public String getIp() {
		return ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}