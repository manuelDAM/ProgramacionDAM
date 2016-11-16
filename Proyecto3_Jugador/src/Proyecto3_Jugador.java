import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Proyecto3_Jugador extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		//Aquí introducimos los datos del jugador
		Jugador player1=new Jugador();
		player1.setNombre("Vicente");
		player1.setApellidos("Sanchez");
		player1.setEdad(33);
		player1.setId(0);
		System.out.println(player1.toString());
		//Introducimos un segundo jugador
		Jugador player2=new Jugador();
		player2.setNombre("Manuel");
		player2.setApellidos("Gimenez");
		player2.setEdad(29);
		player2.setId(1);
		System.out.println(player2.toString());
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyecto3_Jugador frame = new Proyecto3_Jugador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Creación de la ventana (esta vacia)
	public Proyecto3_Jugador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);//Donde modificamos el tamaño de la ventana
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

	}
}