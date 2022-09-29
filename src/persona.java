
public class persona {
	
	private String nombre;
	private String profesion;
	private String mail;
	private String direccion;
	private String telefono;
	
	public void establecerDatos(String nombre, String profesion, String mail, String direccion, String telefono) {
		
		this.nombre = nombre;
		this.profesion = profesion;
		this.mail = mail;
		this.direccion = direccion;
		this.telefono = telefono;
		
	}
	
	public String devolverDatos() {
		
		return ("Nombre: " + this.nombre + ", Profesion: " + this.profesion + ", Dirección de correo: " + this.mail + ", Telefono: " + this.telefono);
	
	}
	
}
