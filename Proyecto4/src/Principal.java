import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//llamada al paquete juego. clase jugador
import Juego.Jugador;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {
//declaro los textfield de texto
	private JPanel contentPane;
	private JTextField textField_nombre;
	private JTextField textField_apellido1;
	private JTextField textField_apellido2;
	private JTextField textField_edad;
	private JTextField textField_4;
	
  //Generamos un nuevo jugador
	Jugador player1=new Jugador();
	private JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Principal() {
		//almacenamos player1 el nombre, apellidos, edad e id
		player1.setNombre("");
		player1.setApellido1("");
		player1.setApellido2("");
		player1.setEdad(999);
		player1.setId(0);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//jlabel del texto datos juegador con el color, fuente, ubicaci�n y tama�o 
		JLabel lblNewLabel = new JLabel("DATOS JUGADOR");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 20));
		lblNewLabel.setBounds(139, 31, 150, 16);
		contentPane.add(lblNewLabel);
		//jlabel del nombre con el color, fuente, ubicaci�n y tama�o 
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(24, 74, 69, 16);
		contentPane.add(lblNombre);
		//jlabel del primer apellido con el color, fuente, ubicaci�n y tama�o 
		JLabel lblApellido = new JLabel("APELLIDO 1");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(24, 103, 114, 16);
		contentPane.add(lblApellido);
		//jlabel del segundo apellido con el color, fuente, ubicaci�n y tama�o 
		JLabel lblApellido_1 = new JLabel("APELLIDO 2");
		lblApellido_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido_1.setBounds(24, 132, 88, 16);
		contentPane.add(lblApellido_1);
		//jlabel de la edad con el color, fuente, ubicaci�n y tama�o 
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEdad.setBounds(24, 161, 56, 16);
		contentPane.add(lblEdad);
		//textfield para introducir la edad
		textField_nombre = new JTextField();
		textField_nombre.setBounds(126, 72, 260, 22);
		contentPane.add(textField_nombre);
		textField_nombre.setColumns(10);	
		textField_nombre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				player1.setNombre(textField_nombre.getText());
				
			}
		});
		//textfield para introducir el primer apellido
		textField_apellido1 = new JTextField();
		textField_apellido1.setBounds(126, 101, 260, 22);
		contentPane.add(textField_apellido1);
		textField_apellido1.setColumns(10);
		textField_apellido1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				player1.setApellido1(textField_apellido1.getText());
			}
		});
		//textfield para introducir el segundo apellido
		textField_apellido2 = new JTextField();
		textField_apellido2.setBounds(126, 132, 260, 22);
		contentPane.add(textField_apellido2);
		textField_apellido2.setColumns(10);
		textField_apellido2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				player1.setApellido2(textField_apellido2.getText());
			}
		});
		//textfield para introducir la edad
		textField_edad = new JTextField();
		textField_edad.setBounds(126, 159, 260, 22);
		contentPane.add(textField_edad);
		textField_edad.setColumns(10);
		textField_edad.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(player1.isNumeric(textField_edad.getText())==true)
				player1.setEdad(Integer.parseInt(textField_edad.getText()));
				else
					player1.setEdad(999);
			       }
		});
		//textfield para mostrar los datos del jugador
		textField_4 = new JTextField();
		textField_4.setBounds(24, 286, 366, 54);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		

		
		//BOTON PARA EMPZAR JUEGO
		JButton btnNewButton = new JButton("EMPEZAR JUEGO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (player1.getEdad()==999)
					textField_4.setText("La edad no es correcta o falta introducir. Pulsa INTRO");
				else if (player1.sonEspacios(player1.getNombre()))
					textField_4.setText("Falta el nombre o no ha pulsado INTRO");
				else if (player1.sonEspacios(player1.getApellido1()))
					textField_4.setText("Falta el primer apellido o no ha pulsado INTRO");
				else if (player1.sonEspacios(player1.getApellido2()))
					textField_4.setText("Falta el el segundo apellido o no ha pulsado INTRO");
				else
					textField_4.setText("Nuevo jugador: "+player1.getNombre()+" "+player1.getApellido1()+" "+player1.getApellido2()+" de "+player1.getEdad()+" a�os");
			}
		});
		//boton para salir de la aplicacion
		btnNewButton.setBounds(24, 231, 362, 25);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("SALIR");
		btnNewButton_1.setBackground(new Color(25, 25, 112));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(363, 0, 69, 22);
		contentPane.add(btnNewButton_1);
	}
}
