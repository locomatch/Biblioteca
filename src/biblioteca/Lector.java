package biblioteca;

import java.util.ArrayList;
import javax.persistence.*;
import java.io.Serializable;
import excepciones.CopiaInexistenteException;
import excepciones.EstadoCopiaException;
import excepciones.MaxCopiasException;
import excepciones.MultaPendienteException;

@Entity
@Table public class Lector implements Serializable {
	
	@Column @Id @GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String nombre;
	
	@Column
	private String telefono;
	
	@Column
	private String direccion;
	
	@OneToOne
	@JoinColumn(name = "multa_id", referencedColumnName = "id")
	private Multa multa;
	
	@Transient
	private ArrayList<Copia> copias;
	

	public Lector(String nom, String tel, String dir) {
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
					copia.adquirir(this);
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
			copia.devolver();
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
