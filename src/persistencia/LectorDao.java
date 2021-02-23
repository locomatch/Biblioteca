package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import biblioteca.Lector;
import jakarta.annotation.Resource;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceContext;

@WebService 
public class LectorDao {

	EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("biblioteca");
	
	EntityManager em = managerFactory.createEntityManager();
	
	EntityTransaction tran = em.getTransaction();
	

	public boolean agregarLector(Lector lector) {
		try {

			tran.begin();
			em.persist(lector);
			tran.commit();
			em.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public List consultarLectores() {
		List lectores = em.createQuery("Select nombre from Lector").getResultList();
		return lectores;
	}
/*
	public Lector consultarLectorPorId(int id) {
		Lector lector = em.find(Lector.class, id);
		System.out.println(lector);
		return lector;
	}
*/	
	
}