package junit;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import biblioteca.Autor;
import biblioteca.Copia;
import biblioteca.Lector;
import biblioteca.Libro;
import biblioteca.tipoLibro;
import excepciones.MaxCopiasException;
import excepciones.MultaPendienteException;

public class ProbarBiblioteca {

	private Autor HR;
	private Libro Harry1, Harry2;
	private Copia Primera, Segunda, Tercera, Cuarta, Quinta, Sexta;
	private Lector Nahue;
	
	@Before
	public void setUp() throws Exception {
		
		this.HR = new Autor("HR", "UK", "1998-01-26"); 
		
		this.Harry1 = new Libro("Harry Potter Y la Piedra Filosofal", tipoLibro.NOVELA, "Editorial 1", 1970, HR);
		this.Harry2 = new Libro("Harry Potter Y la Orden del Phoenix", tipoLibro.NOVELA, "Editorial 1", 1970, HR);
		
		
		this.Primera = new Copia(Harry1);
		this.Segunda = new Copia(Harry1);
		this.Tercera = new Copia(Harry1);	
		this.Cuarta = new Copia(Harry2);
		this.Quinta = new Copia(Harry2);
		this.Sexta = new Copia(Harry2);
		
		this.Nahue = new Lector("Nahue","1564451220", "Provincia");
		
	}

	@Test
	public void testPrestarCuatro() throws MaxCopiasException, MultaPendienteException {
		
		Nahue.adquirir(Primera);
		Nahue.adquirir(Segunda);
		Nahue.adquirir(Tercera);
		Nahue.adquirir(Cuarta);
		
		fail("Preste todos los libros!!");
	}
	
	
	

}
