package textobailando;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class textobailando extends JFrame {
//ATRIBUTOS
	private JPanel contentPane;
	private JTextField textoizquierda;
	private JTextField textoderecha;
	private JButton button_1;
	private JButton btnSalir;

	/**
	 * METODO PRINCIPAL
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					textobailando frame = new textobailando();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * CREANDO LA VENTANA DEL PROGRAMA
	 */
	public textobailando() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textoizquierda = new JTextField();
		textoizquierda.setBounds(12, 128, 116, 22);
		contentPane.add(textoizquierda);
		textoizquierda.setColumns(10);
		
		textoderecha = new JTextField();
		textoderecha.setBounds(289, 128, 116, 22);
		contentPane.add(textoderecha);
		textoderecha.setColumns(10);
		
		JButton button = new JButton("    - - >");  //BOTON DERECHA
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textoderecha.setText(textoizquierda.getText());
				textoizquierda.setText("");
			}
		});
		button.setBounds(144, 70, 97, 25);
		contentPane.add(button);
		
		button_1 = new JButton("  < -   -"); //BOTON IZQUIERDA
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textoizquierda.setText(textoderecha.getText());
				textoderecha.setText("");
			}
		});
		button_1.setBounds(144, 192, 97, 25);
		contentPane.add(button_1);
		
		btnSalir = new JButton("SALIR"); //BOTON SALIR
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnSalir.setBounds(323, 215, 97, 25);
		contentPane.add(btnSalir);
	}
}

