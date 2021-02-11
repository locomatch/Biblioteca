
public class Copia{

	private static long idCounter = 0;
	
	private String identificador;
	
	private Libro libro;
	private estadoCopia estado;
	private int tiempoPrestado;
	



	public static synchronized String createID()
	{
	    return String.valueOf(idCounter++);
	}   
	
	public Copia(Libro libro) {
		super();
		this.identificador = createID();
		this.libro = libro;
		this.estado = estadoCopia.DISPONIBLE;
		this.tiempoPrestado = 0;
	}
	
	public estadoCopia estadoActual() {
		return estado;
	}
	
	public void cambiarEstado(estadoCopia nuevoEstado) {
		estado = nuevoEstado;
	}


	
	
}
