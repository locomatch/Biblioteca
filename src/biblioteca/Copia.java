package biblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import excepciones.MaxCopiasException;


public class Copia{

	private static long idCounter = 1;
	
	private String identificador;
	
	private Libro libro;
	private estadoCopia estado;
	private LocalDate inicioPrestamo;
	



	public static synchronized String createID()
	{
	    return String.valueOf(idCounter++);
	}   
	
	public Copia(Libro libro) {
		super();
		this.identificador = createID();
		this.libro = libro;
		this.estado = estadoCopia.DISPONIBLE;
		LocalDate inicio = LocalDate.parse("1111-11-11");
		inicioPrestamo = inicio;
	}
	
	public estadoCopia estadoActual() {
		return estado;
	}
	
	public void cambiarEstado(estadoCopia nuevoEstado) {
		estado = nuevoEstado;
	}

	
	public long getTiempoPrestado() {
		LocalDate finPrestamo = LocalDate.now();
		
		return ChronoUnit.DAYS.between(inicioPrestamo, finPrestamo);

	}
	
	public void checkMulta() {
		if (getTiempoPrestado() > 30) {
			
		}
	}
	
	public void adquirir() throws MaxCopiasException {
		if (estadoActual() == estadoCopia.DISPONIBLE) {
			cambiarEstado(estadoCopia.PRESTADO);
			inicioPrestamo = LocalDate.now();
			System.out.println("Copia Adquirida!");
		}
		else
			throw new MaxCopiasException();
		
	}
	


	
	
}
