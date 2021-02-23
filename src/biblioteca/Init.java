package biblioteca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import excepciones.CopiaInexistenteException;
import excepciones.EstadoCopiaException;
import excepciones.MaxCopiasException;
import excepciones.MultaPendienteException;
import jakarta.xml.ws.Endpoint;
import servicios.LectorService;

public class Init {

	public static void main(String[] args) throws MaxCopiasException, CopiaInexistenteException, MultaPendienteException, EstadoCopiaException {


		
		Endpoint endPoint = Endpoint.publish("http://localhost:8080/LectorService", new LectorService());
		
		Autor hr = new Autor("HR", "UK", "1998-01-26"); 
		
		Libro harry1 = new Libro("Harry Potter Y la Piedra Filosofal", tipoLibro.NOVELA, "Editorial 1", 1970, hr);
		Libro harry2 = new Libro("Harry Potter Y la Orden del Phoenix", tipoLibro.NOVELA, "Editorial 1", 1970, hr);
		
		
		Copia primera = new Copia(harry1);
		Copia segunda = new Copia(harry1);
		Copia tercera = new Copia(harry1);
		
		Copia cuarta = new Copia(harry2);
		Copia quinta = new Copia(harry2);
		Copia sexta = new Copia(harry2);
		
		
		
		Lector nahue = new Lector("Nahue","1564451220", "Provincia");
		
		nahue.adquirir(primera);
		nahue.devolver(primera);
		nahue.adquirir(segunda);
	//	Nahue.adquirir(Cuarta);
	//	Nahue.adquirir(Sexta);
	//	Nahue.devolver(Primera);
	//	Nahue.adquirir(Sexta);
		
	//	System.out.println(Sexta.getTiempoPrestado());
	
		/*	
		EntityTransaction tran = em.getTransaction();
		tran.begin();
			em.persist(hr);
			em.persist(harry1);
			em.persist(harry2);
			em.persist(nahue);
			em.persist(primera);
			em.persist(segunda);
			em.persist(tercera);
			em.persist(cuarta);
			em.persist(quinta);
			em.persist(sexta);
			
		tran.commit();
		em.close();
		*/
	}
}
