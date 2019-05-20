package Sockets;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.*;

public class servidor {

	public static void main(String[] args) {
		mimarco frame = new mimarco();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

/**
 * Create the frame.
 */
class mimarco extends JFrame implements Runnable {

	public mimarco() {
		setBounds(300, 300, 300, 300);
		JPanel mipanel = new JPanel();
		mipanel.setLayout(new BorderLayout());
		areatexto = new JTextArea();
		areatexto.setEditable(false);
		mipanel.add(areatexto, BorderLayout.CENTER);
		add(mipanel);
		setVisible(true);
		Thread mihilo = new Thread(this);
		mihilo.start();
	}

	private JTextArea areatexto;

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			ServerSocket servidor = new ServerSocket(7070);

			String nick, ip, mensaje;
			
			ArrayList<String> listaip = new ArrayList<String>();

			paqueteenvio paquete_recibido;

			while (true) {

				Socket misocket = servidor.accept();

				ObjectInputStream paquete_datos = new ObjectInputStream(misocket.getInputStream());
				paquete_recibido = (paqueteenvio) paquete_datos.readObject();

				nick = paquete_recibido.getNick();
				ip = paquete_recibido.getIp();
				mensaje = paquete_recibido.getMensaje();

				if (!mensaje.equals("online")) {

					areatexto.append("\n" + nick + ": " + mensaje + " (para " + ip + ")");

					Socket enviadestino = new Socket(ip, 9090);

					ObjectOutputStream paquetereenvio = new ObjectOutputStream(enviadestino.getOutputStream());

					paquetereenvio.writeObject(paquete_recibido);

					paquetereenvio.close();

					enviadestino.close();

					misocket.close();

				} else {
					
					InetAddress localizacion = misocket.getInetAddress();
					String ipremota = localizacion.getHostAddress();
					
					areatexto.append("\n" + ipremota + " se ha conectado");
					
					listaip.add(ipremota);
					
					paquete_recibido.setIps(listaip);
					
					for (String z:listaip) {
						
						Socket enviadestino = new Socket(z, 9090);

						ObjectOutputStream paquetereenvio = new ObjectOutputStream(enviadestino.getOutputStream());

						paquetereenvio.writeObject(paquete_recibido);

						paquetereenvio.close();

						enviadestino.close();

						misocket.close();
						
					}
				}
			}

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
