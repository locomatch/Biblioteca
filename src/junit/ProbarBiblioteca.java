package junit;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import biblioteca.Autor;
import biblioteca.Copia;
import biblioteca.Lector;
import biblioteca.Libro;
import biblioteca.tipoLibro;
import excepciones.CopiaInexistenteException;
import excepciones.EstadoCopiaException;
import excepciones.MaxCopiasException;
import excepciones.MultaPendienteException;

public class ProbarBiblioteca {

	private Autor hr;
	private Libro harry1, harry2;
	private Copia primera, segunda, tercera, cuarta, quinta, sexta;
	private Lector nahue, santi;
	
	@Before
	public void setUp() throws Exception {
		
		this.hr = new Autor("HR", "UK", "1998-01-26"); 
		
		this.harry1 = new Libro("Harry Potter Y la Piedra Filosofal", tipoLibro.NOVELA, "Editorial 1", 1970, hr);
		this.harry2 = new Libro("Harry Potter Y la Orden del Phoenix", tipoLibro.NOVELA, "Editorial 1", 1970, hr);
		
		
		this.primera = new Copia(harry1);
		this.segunda = new Copia(harry1);
		this.tercera = new Copia(harry1);	
		this.cuarta = new Copia(harry2);
		this.quinta = new Copia(harry2);
		this.sexta = new Copia(harry2);
		
		this.nahue = new Lector("Nahue","1564451220", "Provincia");
		this.santi = new Lector("Santi","1564451220", "Caballito");
		
	}

	@Test
	public void testPrestarCuatro() throws MaxCopiasException, MultaPendienteException, CopiaInexistenteException, EstadoCopiaException {
		
		nahue.adquirir(primera);
		nahue.adquirir(segunda);
		nahue.adquirir(tercera);
		nahue.adquirir(cuarta);
		
		fail("Adquirió más de 3 libros");
	}
	
	@Test
	public void testDevolverInexistente() throws CopiaInexistenteException {
		
		nahue.devolver(primera);
		
		fail("Devolvió copia que no tenia");
	}
	
	@Test
	public void testCopiaNoDisponible() throws CopiaInexistenteException, EstadoCopiaException, MaxCopiasException, MultaPendienteException {
		nahue.adquirir(primera);
		santi.adquirir(primera);
		
		fail("Adquirió la copia de otra persona");
	}
	
	
	
	
	

}
