package biblioteca;

import java.util.ArrayList;

import excepciones.CopiaInexistenteException;
import excepciones.EstadoCopiaException;
import excepciones.MaxCopiasException;
import excepciones.MultaPendienteException;

public class Lector {
	
	private static int idCounter = 1;
	
	private int nSocio;
	private String nombre;
	private String telefono;
	private String direccion;
	
	private Multa multa;
	
	private ArrayList<Copia> copias;
	
	public static synchronized int createID()
	{
	    return idCounter++;
	}   
	public Lector(String nom, String tel, String dir) {
		nSocio = createID();
		nombre = nom;
		telefono = tel;
		direccion = dir;
		copias = new ArrayList<Copia>();
		multa = null;
	}
	
	public void adquirir(Copia copia) throws MaxCopiasException, MultaPendienteException, EstadoCopiaException {
		checkMulta();
		if(multa == null) {
			if(copias.size() < 3) {
				if (copia.estadoActual() == estadoCopia.DISPONIBLE) {
					copias.add(copia);
					copia.adquirir();
				}
				else
					throw new EstadoCopiaException();
			}
			else
				throw new MaxCopiasException();
		}
		else
			throw new MultaPendienteException(multa.diasRestantes());

		
		}
	
	public void devolver(Copia copia) throws CopiaInexistenteException {
		
		long tiempoPrest;
		
		if(copias.contains(copia)) {
			tiempoPrest = copia.getTiempoPrestado();
			if(tiempoPrest > 30) {
				multa = new Multa((tiempoPrest-30)*2, this);
			}
			copias.remove(copia);
			copia.cambiarEstado(estadoCopia.DISPONIBLE);
			System.out.println("Copia devuelta!");
		}
		else
			throw new CopiaInexistenteException();
		

	}
	
	private void checkMulta() {
		if(multa != null) {
			if(multa.diasRestantes() <= 0)
				multa = null;
		}
	}
	
}
