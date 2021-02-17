package biblioteca;

public class Libro {

	private static int idCounter = 1;
	
	private int id;
	
	private String titulo;
	private tipoLibro tipoLibro;
	private String editorial;
	private int anio;
	private Autor autor;

	
	public static synchronized int createID()
	{
	    return idCounter++;
	}   
		
	
	public Libro(String tit, tipoLibro lib, String edi, int ani, Autor aut) {
		id = createID();
		titulo = tit;
		tipoLibro = lib;
		editorial = edi;
		anio = ani;
		autor = aut;
	}


}
