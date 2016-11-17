public class Jugador {
	 public class java {

	}
	//Declaramos las variables 
	 private String Nombre;
	 private String Apellidos;
	 private int Edad;
	 private int Puntos;
	 private int Id;
	 
	 public String getNombre() {
		 return Nombre;
	 }
	 public void setNombre(String Nombre){
		 this.Nombre = Nombre;
	 }
	
	 public String getApellidos(){
		 return Apellidos;
	 }
	 
	 public void setApellidos(String Apellidos){
		 this.Apellidos = Apellidos;
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
	 //devolvemos a la clase principal nombre, apellido y edad
	 public String toString(){
		 return this.Nombre+" "+this.Apellidos+" "+this.Edad;
      }
	 
 }