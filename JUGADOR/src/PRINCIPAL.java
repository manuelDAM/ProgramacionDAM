import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//Llamamos al paquete Jugador
import JUGADOR.JUGADOR;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PRINCIPAL extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		//Aquí introducimos los datos del jugador
		JUGADOR player1=new JUGADOR();
		player1.setNombre("Vicente");
		player1.setApellidos("Sanchez");
		player1.setEdad(35);
		player1.setId(0);
		System.out.println(player1.toString());
		//Introducimos un segundo jugador
		JUGADOR player2=new JUGADOR();
		player2.setNombre("Manuel");
		player2.setApellidos("Gimenez");
		player2.setEdad(29);
		player2.setId(1);
		System.out.println(player2.toString());
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PRINCIPAL frame = new PRINCIPAL();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Creación de la ventana (esta vacia)
	public PRINCIPAL() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);//Donde aparece y el tamaño de la ventana
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ventana vacia");
		lblNewLabel.setBounds(273, 193, 89, 10);
		contentPane.add(lblNewLabel);
		

	}
}
