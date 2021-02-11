//import java.util.Date;

public class Libro {

	private static long idCounter = 0;
	
	private String id;
	
	private String titulo;
	private tipoLibro tipoLibro;
	private String editorial;
	private String anio;
	private Autor autor;

	
	public static synchronized String createID()
	{
	    return String.valueOf(idCounter++);
	}   
		
	
	public Libro(String tit, tipoLibro lib, String edi, String ani, Autor aut) {
		id = createID();
		titulo = tit;
		tipoLibro = lib;
		editorial = edi;
		anio = ani;
		autor = aut;
	}
	

}
