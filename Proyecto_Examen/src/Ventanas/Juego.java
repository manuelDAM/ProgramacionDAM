package Ventanas;
import java.util.Random;
import Juego.Jugador;


import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Juego extends JFrame {

	private JPanel contentPane;
    private Jugador j;
    private JButton btnSalir; //declaro el botón "SALIR"
     //Array de dados
    private ImageIcon[] dados3=new ImageIcon[3];
    private ImageIcon[] dados6=new ImageIcon[6];
    private ImageIcon[] dados12=new ImageIcon[12];
    private ImageIcon dadoGris;
    private Random dado=new Random(); //variable para controlar el random de los dados
    
    //Almacenamos los numeros aleatorios para realizar el cálculo
    private int[] numerosAlmacenadosDados3=new int[3];
    private int[] numerosAlmacenadosDados6=new int[2];
    private int numerosAlmacenadosDados12;
    
    //Clase que almacena el jugador
  //  private Jugador player;
    JLabel nombreJugador;
    JLabel puntuacion;
    
    //Jlabel de las imágenes
    private JLabel dado1,dado2,dado3, dado4, dado5, dado6;
    
    //Jlabel de los botones de control
    private JButton suma,resta,mathdice;
    //cada de resutado
    private JTextField resultado;
    
    //diferentes variable que nos permiten realizar el contro de la app
    private boolean tocaNumero=true;
    private int operacion=0;
    private int numerosIntroducidos=0;
    private boolean esSuma=true;
    
    //JLabel de muestra de resultados
    private JLabel resultadoLabel;
    private JLabel resultadoOK;
    //Boton repetir
    private JButton repetir;
    
    //manejador de la base de datos
    
    
    
    
    
    
	public Juego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1000, 530);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
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
		btnSalir.setBounds(1113, 0, 69, 22); //lugar de colocación del botón
		contentPane.add(btnSalir);
        
        dado1= new JLabel("");
        dado1.setBounds(10, 10, 150, 150);
        contentPane.add(dado1); 
       
        dado2= new JLabel("");
        dado2.setBounds(160, 10, 150, 150);
        contentPane.add(dado2); 
        
        dado3= new JLabel("");
        dado3.setBounds(310, 10, 150, 150);
        contentPane.add(dado3); 
        
        dado4= new JLabel("");
        dado4.setBounds(10, 160, 150, 150);
        contentPane.add(dado4); 
        
        dado5= new JLabel("");
        dado5.setBounds(160, 160, 150, 150);
        contentPane.add(dado5); 
        
        dado6= new JLabel("");
        dado6.setBounds(10, 310, 173, 173);
        contentPane.add(dado6); 
        
        //colocamos los bobontes de suma y resta
        suma = new JButton("+");
        suma.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(!tocaNumero){
        			resultado.setText(resultado.getText()+"+");
        			tocaNumero=true;
        			esSuma=true;			
        		}
        	}
        });
        suma.setFont(new Font("Tahoma", Font.PLAIN, 24));
        suma.setBounds(510, 78, 195, 63);
        contentPane.add(suma);
        
        resta = new JButton("-");
        resta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(!tocaNumero){
        			resultado.setText(resultado.getText()+"-");
        			tocaNumero=true;
        			esSuma=false;			
        		}
        	}
        });
        resta.setFont(new Font("Tahoma", Font.PLAIN, 24));
        resta.setBounds(779, 78, 195, 63);
        contentPane.add(resta);
        
        //texto bienvenida jugador
        nombreJugador = new JLabel("Bienvenido");
        nombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 25));
        nombreJugador.setHorizontalAlignment(SwingConstants.CENTER);
        nombreJugador.setBounds(510, 5, 464, 39);
        contentPane.add(nombreJugador);
        
        //caja resultados     
        resultado = new JTextField();
        resultado.setEditable(false);
        resultado.setBounds(510, 160, 464, 63);
        resultado.setFont(new Font("Tahoma", Font.PLAIN, 36));
        contentPane.add(resultado);
        resultado.setColumns(10);
        
        //colocamos el boton de resultado
        mathdice = new JButton("MATHDICE");
        mathdice.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e) {
             //	 if(numerosAlmacenadosDados12>1) {
            	//	 resultadoLabel.setText("Tu operación es "+String.valueOf(operacion));
            	//     repetir.setEnabled(true);
            	     if((numerosAlmacenadosDados12)==operacion){
            	         resultadoOK.setText("¡CORRECTO!"); //el resultado es correcto
            	         mathdice.setEnabled(false); 
            	          j.setPuntos(j.getPuntos()+5);
            	        puntuacion.setText("Tu puntuación es: "+j.getPuntos());
            	       }
             		else{
             			resultadoOK.setText("INTÉNTALO DE NUEVO");
             			mathdice.setEnabled(true);
             			//j.Puntos=-2;
             			 puntuacion.setText("Tu puntuación es: "+j.getPuntos());
             		//	j.Puntos=-2;
             		}
            	 }
           //    } 
             });
        
        mathdice.setFont(new Font("Tahoma", Font.PLAIN, 24));
        mathdice.setBounds(510, 236, 464, 63);
        contentPane.add(mathdice);
        
        //cajas de resultados
        resultadoLabel = new JLabel("");
        resultadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultadoLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        resultadoLabel.setBounds(510, 467, 464, 52);
        contentPane.add(resultadoLabel);
        
        //caja resultados OK
        resultadoOK = new JLabel ("");
        resultadoOK.setHorizontalAlignment(SwingConstants.CENTER);
        resultadoOK.setFont(new Font("Tahoma", Font.PLAIN, 36));
        resultadoOK.setBounds(510, 408, 464, 41);
        contentPane.add(resultadoOK);
        
        //boton repetir
       repetir = new JButton("REPETIR");
        repetir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	inicializarBotones();
            	//al apretar repetir reactivamos boton mathdice
            	mathdice.setEnabled(true);
            	repetir.setEnabled(true);
            }
        });
        repetir.setEnabled(true);
        repetir.setFont(new Font("Tahoma", Font.PLAIN, 24));
        repetir.setBounds(510, 310, 464, 63);
        contentPane.add(repetir);
        
        //caja de puntuacion
        puntuacion = new JLabel("");
        puntuacion.setHorizontalAlignment(SwingConstants.CENTER);
        puntuacion.setFont(new Font("Tahoma", Font.PLAIN, 25));
        puntuacion.setBounds(510, 35, 464, 32);
        contentPane.add(puntuacion);
        
        inicializarBotones();
	 }
        
        

public void setJugador(Jugador j) //paso jugador a j
{

    nombreJugador.setText("Bienvenido al juego "+j.getNombre()); //texto mostrado en la ventana Juego
    puntuacion.setText("Tu puntuación es: "+j.getPuntos());
    
 }

private void inicializarBotones(){
	//cargamos todas las imagenes en los arrays
	for(int i=0;i<dados3.length;i++){
		 dados3[i]=new ImageIcon(getClass().getResource("Imagenes/dado"+String.valueOf(i+1)+"_3.png"));
	}
	for(int i=0;i<dados6.length;i++){
		 dados6[i]=new ImageIcon(getClass().getResource("Imagenes/dado"+String.valueOf(i+1)+"_6.png"));
	}
	for(int i=0;i<dados12.length;i++){
		 dados12[i]=new ImageIcon(getClass().getResource("Imagenes/dadodoce_"+String.valueOf(i+1)+".png"));
	}
	dadoGris= new ImageIcon(getClass().getResource("Imagenes/dadogris.png"));
	
	//colocamos los dados de 3 caras
	    for(int i=0;i<numerosAlmacenadosDados3.length;i++) numerosAlmacenadosDados3[i]=dado.nextInt(3);
	    dado1.setIcon(dados3[numerosAlmacenadosDados3[0]]); //imagen dentro de los JLabel
	    dado1.setName("1");
	    dado2.setIcon(dados3[numerosAlmacenadosDados3[1]]);
	    dado2.setName("2");
	    dado3.setIcon(dados3[numerosAlmacenadosDados3[2]]);
	    dado3.setName("3");
	    dado1.addMouseListener(new ListenerDados());
	    dado2.addMouseListener(new ListenerDados());
	    dado3.addMouseListener(new ListenerDados());
	    
	//colocamos los dados de 6 caras
	    for(int i=0;i<numerosAlmacenadosDados6.length;i++) numerosAlmacenadosDados6[i]=dado.nextInt(6);
	    dado4.setIcon(dados6[numerosAlmacenadosDados6[0]]);
	    dado4.setName("4");
	    dado5.setIcon(dados6[numerosAlmacenadosDados6[1]]);
	    dado5.setName("5");
	    dado4.addMouseListener(new ListenerDados());
	    dado5.addMouseListener(new ListenerDados());
	    
	 //colocamos los dados de 12 caras
	    numerosAlmacenadosDados12=dado.nextInt(12); //numero aleatorio
	    dado6.setIcon(dados12[numerosAlmacenadosDados12]);
	    //reseteamos las cajas
	    resultadoLabel.setText("");
	    resultadoOK.setText("");
	    resultado.setText("");
	    
	    //reseteamos semaforos y valores
	    tocaNumero=true;
	    operacion=0;
	    numerosIntroducidos=0;
	    esSuma=true;
	    	}
     //implementacion de un ActionListener
       private class ListenerDados implements MouseListener {
    	   
    	   @Override
    	   public void mouseClicked(MouseEvent e) {
    		   JLabel dado = (JLabel) e.getSource();
    		   int numeroDado=Integer.valueOf(dado.getName());
    		   if(tocaNumero){
    			   if(numeroDado<4)
    				     resultado.setText(resultado.getText()+String.valueOf(numerosAlmacenadosDados3[numeroDado-1]+1));
    			   else
    				     resultado.setText(resultado.getText()+String.valueOf(numerosAlmacenadosDados6[numeroDado-4]+1));
    		      dado.removeMouseListener(this);
    		      dado.setIcon(dadoGris);
    		      tocaNumero=false;
    		      if(numeroDado<4)
    		    	  setOperacion(numerosAlmacenadosDados3[numeroDado-1]+1);
    		      else
    		    	  setOperacion(numerosAlmacenadosDados3[numeroDado-4]+1);
    		   }
    	   }


		private void setOperacion(int i) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    		   
    	  
    	   
    	   
       }


}


