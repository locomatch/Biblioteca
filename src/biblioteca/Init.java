package biblioteca;

import excepciones.CopiaInexistenteException;
import excepciones.EstadoCopiaException;
import excepciones.MaxCopiasException;
import excepciones.MultaPendienteException;

public class Init {

	public static void main(String[] args) throws MaxCopiasException, CopiaInexistenteException, MultaPendienteException, EstadoCopiaException {

		Autor hr = new Autor("HR", "UK", "1998-01-26"); 
		
		Libro harry1 = new Libro("Harry Potter Y la Piedra Filosofal", tipoLibro.NOVELA, "Editorial 1", 1970, hr);
		Libro harry2 = new Libro("Harry Potter Y la Orden del Phoenix", tipoLibro.NOVELA, "Editorial 1", 1970, hr);
		
		
		Copia primera = new Copia(harry1);
		Copia segunda = new Copia(harry1);
		Copia tercera = new Copia(harry1);
		
		Copia cuarta = new Copia(harry2);
		Copia quinta = new Copia(harry2);
		Copia sexta = new Copia(harry2);
		
		
		
		Lector Nahue = new Lector("Nahue","1564451220", "Provincia");
		
		Nahue.adquirir(primera);
		Nahue.devolver(primera);
		Nahue.adquirir(segunda);
	//	Nahue.adquirir(Cuarta);
	//	Nahue.adquirir(Sexta);
	//	Nahue.devolver(Primera);
	//	Nahue.adquirir(Sexta);
		
	//	System.out.println(Sexta.getTiempoPrestado());
		
		
	}

}
