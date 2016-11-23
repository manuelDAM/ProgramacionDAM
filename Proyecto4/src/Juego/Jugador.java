package Juego;
//clase jugador dentro del paquete juego
public class Jugador {

	//Declaramos las variables 
	 private String Nombre;
	 private String Apellido1;
	 private String Apellido2;
	 private int Edad;
	 private int Puntos;
	 private int Id;
	 
	 public String getNombre() {
		 return Nombre;
	 }
	 public void setNombre(String Nombre){
		 this.Nombre = Nombre;
	 }
	
	 public String getApellido1(){
		 return Apellido1;
	 }
	 
	 public void setApellido1(String Apellido1){
		 this.Apellido1 = Apellido1;
	 }
	 public String getApellido2(){
		 return Apellido2;
	 }
	 
	 public void setApellido2(String Apellido2){
		 this.Apellido2 = Apellido2;
	 }
	 public int getEdad() {
		 return Edad;
	 }
	
	 public void setEdad(int Edad) {
		 this.Edad = Edad;
	 }
	 
	 public int getPuntos() {
		 return Puntos;
	 }
	 
	 public void setPuntos(int Puntos) {
		 this.setEdad(Puntos);
	 }
	 
	 public int getId() {
		 return Id;
	 }
	 
	 public void setId(int Id) {
		 this.Id = Id;
	 }
	 
	 public Jugador() {
	 
	 }
	 //funcion para determinar si en edad se ha introducido un número
	 public boolean isNumeric(String cadena){
		 try {
			 Integer.parseInt(cadena);
			 return true;
		 } catch (NumberFormatException nfe){
			 return false;
		 }
	 }
	 //funcion para determinar si el textfield esta vacio
	 public boolean sonEspacios(String cad)
	 {
		 for(int i =0; i<cad.length(); i++)
		 if(cad.charAt(i) != ' ')
		 return false;
		 
		 return true;
	 }
	 
	 //devolvemos a la clase principal nombre, apellido y edad
	 public String toString(){
		 return this.Nombre+" "+this.Apellido1+" de "+this.Edad+" años";
     }
	 
}