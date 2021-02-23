package servicios;

import java.util.ArrayList;
import java.util.List;

import biblioteca.Lector;
import jakarta.annotation.Resource;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.xml.ws.Endpoint;
import jakarta.xml.ws.WebServiceContext;
import persistencia.LectorDao;


@WebService
public class LectorService {
	
	
	@WebMethod(operationName="agregarLectorWS")	
	public boolean agregarLector(@WebParam(name="lector")Lector lector) {
		LectorDao dao = new LectorDao();
		try {
			dao.agregarLector(lector);
		}
		catch (Exception e) {
			e.printStackTrace();
		return false;
		}
	return true;
	}
	
	@WebMethod(operationName="consultarLectoresWS")
	public List obtenerLectores() {
		LectorDao dao = new LectorDao();
		List lectores;
		try {
			lectores = dao.consultarLectores();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return lectores;
	}

}



