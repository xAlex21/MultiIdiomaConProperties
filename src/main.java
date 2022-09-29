import java.io.*;
import java.util.Properties;
import java.util.Scanner;


public class main {

	public static void main (String [ ] args) throws FileNotFoundException, IOException{
		
		String espanol[] = {"ES", "Español", "Spanish"}; 
		String english[] = {"EN", "Ingles", "English"}; 
		
		Properties idioma = new Properties();
		Properties lenguaje = new Properties();
		
		idioma.load(new FileReader("resources\\_IDIOMA.properties"));
		
		if (idioma.getProperty("idioma", "").equals("ES")) {
			lenguaje.load(new FileReader("resources\\_ES.properties"));
		}else if (idioma.getProperty("idioma", "").equals("EN")) {
			lenguaje.load(new FileReader("resources\\_EN.properties"));
        }else {
        	lenguaje.load(new FileReader("resources\\_ES.properties"));
        }
		
		Scanner entradaEscaner = new Scanner (System.in);
		
		String idiomaIntroducido;
		boolean continuar = true;

		FileWriter myWriter = new FileWriter("resources\\_IDIOMA.properties");
		do{
			
			System.out.println(lenguaje.getProperty("elec_idioma", ""));
			idiomaIntroducido = entradaEscaner.nextLine ();
			
			for (int i = 0; i < 3; i++){
				
			    if(espanol[i].equalsIgnoreCase(idiomaIntroducido)) {
			    	idioma.setProperty("idioma","ES");
			    	lenguaje.load(new FileReader("resources\\_ES.properties"));
			    	try {
			    		  FileOutputStream os=new FileOutputStream("resources\\_IDIOMA.properties");	
			    		  idioma.store(os, null);
			    		} catch(IOException ioe) {ioe.printStackTrace();}
			    	
			    	continuar = true;
			    	break;
			    }else if(english[i].equalsIgnoreCase(idiomaIntroducido)) {
			    	idioma.setProperty("idioma","EN");
			    	lenguaje.load(new FileReader("resources\\_EN.properties"));
			    	try {
			    		  FileOutputStream os=new FileOutputStream("resources\\_IDIOMA.properties");	
			    		  idioma.store(os, null);
			    		} catch(IOException ioe) {ioe.printStackTrace();}
			    	
			    	continuar = true;
			    	break;
			    }else {
			    	continuar = false;
			    }
			}
			
		}while(!continuar);
		
		System.out.println(lenguaje.getProperty("descripcion", ""));
		
		System.out.println(lenguaje.getProperty("nombre", ""));
		String nombre = entradaEscaner.nextLine ();
		
		System.out.println(lenguaje.getProperty("profesion", ""));
		String profesion = entradaEscaner.nextLine ();
		
		System.out.println(lenguaje.getProperty("mail", ""));
		String mail = entradaEscaner.nextLine ();
		
		System.out.println(lenguaje.getProperty("direccion", ""));
		String direccion = entradaEscaner.nextLine ();
		
		System.out.println(lenguaje.getProperty("telefono", ""));
		String telefono = entradaEscaner.nextLine ();
		
		

		persona p = new persona();
		
		p.establecerDatos(nombre, profesion, mail, direccion, telefono);
		
		System.out.println(p.devolverDatos());
		
		System.out.println(lenguaje.getProperty("gracias", ""));

	}
	
}
