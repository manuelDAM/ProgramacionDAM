package Ventanas;

import Juego.Jugador;


import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Juego extends JFrame {

	private JPanel contentPane;
    private Jugador j;
    private JLabel lblNewLabel;
    private JButton btnSalir; //declaro el botón "SALIR"
    private ImageIcon prox;
    private JLabel lblNewLabel_1;

	public Juego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		btnSalir = new JButton("SALIR"); //texto del boton
		btnSalir.setBackground(new Color(240, 240, 240)); //color del fondo del botón
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnSalir.setForeground(Color.RED); //color de las letras del botón
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11)); //fuente del botón es Tahoma
		btnSalir.setBounds(363, 0, 69, 22); //lugar de colocación del botón
		contentPane.add(btnSalir);
	

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(68, 51, 285, 16);
        contentPane.add(lblNewLabel);
        
        //imagen dentro de un jlabel
        lblNewLabel_1 = new JLabel();
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon imagen=new ImageIcon(getClass().getResource("/img/prox.png"));
        lblNewLabel_1.setIcon(imagen);
        lblNewLabel_1.setBounds(40, 80, 360, 250);
        contentPane.add(lblNewLabel_1);
        
	}

public void setJugador(Jugador j) //paso jugador a j
{

    lblNewLabel.setText("Hola "+j.getNombre()+" bienvenido al juego."); //texto mostrado en la ventana Juego
    
 }
}