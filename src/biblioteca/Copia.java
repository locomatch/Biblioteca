package biblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import excepciones.MaxCopiasException;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table public class Copia implements Serializable{


	@Column @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int identificador;
	
	@OneToOne
	@JoinColumn(name = "libro_id", referencedColumnName = "id")
	private Libro libro;
	
	@Column
	private estadoCopia estado;
	
	@Column
	private LocalDate inicioPrestamo;
	
	@OneToOne
	@JoinColumn(name = "lector_id", referencedColumnName = "id")
	private Lector lector = null;
	
	public Copia(Libro libro) {
		super();
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
	
	public void adquisicionLector(Lector nuevoLector) {
		lector = nuevoLector;
	}
	
	public void debolucionLector(Lector nuevoLector) {
		lector = null;
	}
	
	
	
	
	public void adquirir(Lector auxLector) throws MaxCopiasException {
		if (estadoActual() != estadoCopia.DISPONIBLE) {
			throw new MaxCopiasException();
		}
		cambiarEstado(estadoCopia.PRESTADO);
		inicioPrestamo = LocalDate.now();
		lector = auxLector;
		System.out.println("Copia Adquirida!");
	}
		
	public void devolver() {
		cambiarEstado(estadoCopia.DISPONIBLE);
		lector = null;
		System.out.println("Copia devuelta!");
	}

	
}
