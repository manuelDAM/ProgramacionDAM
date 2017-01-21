package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//llamada al paquete juego. clase jugador
import Juego.Jugador;
import Ventanas.Juego;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
//declaro los textfield de texto
	private JPanel contentPane;
	private JTextField textField_nombre;
	private JTextField textField_apellido1;
	private JTextField textField_apellido2;
	private JTextField textField_edad;
	private JTextField textField_4;
	private JButton btnSalir; //declaro el botón "SALIR"
	private Juego ventana_Juego;
    private Jugador player1=new Jugador("");
	
	
	public Login(Juego vJ) {
		
	
		ventana_Juego=vJ;
		setTitle("¡MATHDICE!");//texto que aparece arriba de la ventana
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
		//jlabel del texto datos juegador con el color, fuente, ubicación y tamaño 
		JLabel lblNewLabel = new JLabel("DATOS JUGADOR");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 20));
		lblNewLabel.setBounds(139, 31, 150, 16);
		contentPane.add(lblNewLabel);
		//jlabel del nombre con el color, fuente, ubicación y tamaño 
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(24, 74, 69, 16);
		contentPane.add(lblNombre);
		//jlabel del primer apellido con el color, fuente, ubicación y tamaño 
		JLabel lblApellido = new JLabel("APELLIDO 1");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(24, 103, 114, 16);
		contentPane.add(lblApellido);
		//jlabel del segundo apellido con el color, fuente, ubicación y tamaño 
		JLabel lblApellido_1 = new JLabel("APELLIDO 2");
		lblApellido_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido_1.setBounds(24, 132, 88, 16);
		contentPane.add(lblApellido_1);
		//jlabel de la edad con el color, fuente, ubicación y tamaño 
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
			public void actionPerformed(ActionEvent arg0) 
			{

				/*condiciones para entrar a la ventana juego 
				 (INTRODUCIR TODOS LOS DATOS PRESIONANDO ENTER Y SER MAYOR DE 18 AÑOS)*/
			//	 if (player1.isNumeric(player1.getEdad()))   ME DA ERROR EN LA FUNCION isNumeric
				//		textField_4.setText("Has introducido carácteres en edad, introduce tu edad en números");
				if (player1.getEdad()==999)
					textField_4.setText("La edad no es correcta o falta introducir. Pulsa INTRO");
				if (player1.getEdad()<18)
					textField_4.setText(" "+player1.getNombre()+", tienes que ser mayor de 18 años para jugar a este juego");				
				else if (player1.sonEspacios(player1.getNombre()))
					textField_4.setText("Falta el nombre o no ha pulsado INTRO");
				else if (player1.sonEspacios(player1.getApellido1()))
					textField_4.setText("Falta el primer apellido o no ha pulsado INTRO");
				else if (player1.sonEspacios(player1.getApellido2()))
					textField_4.setText("Falta el el segundo apellido o no ha pulsado INTRO");
				else {	
		    	    ventana_Juego.setJugador(player1); //a ventana_Juego le paso los datos de player1
			    	ventana_Juego.setVisible(true);	//abro la ventana Juego que la llamo ventana_Juego   	
			        dispose(); //cierro la ventana login		    	
			        }
			}						
		});
		  
		//boton para salir de la aplicacion
		btnNewButton.setBounds(24, 231, 362, 25);
		contentPane.add(btnNewButton);
		
		btnSalir = new JButton("SALIR"); //texto del boton
		btnSalir.setBackground(new Color(240, 240, 240)); //color del fondo del botón
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnSalir.setForeground(Color.RED); //color de las letras del botón
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11)); //fuente del botón
		btnSalir.setBounds(363, 0, 69, 22); //lugar de colocación del botón
		contentPane.add(btnSalir);
	}
}
