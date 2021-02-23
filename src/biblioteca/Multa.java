 package biblioteca;

import java.io.Serializable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.*;

@Entity
@Table public class Multa implements Serializable{

	@Column @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private LocalDate inicioMulta;
	
	@Column
	private long diasDeRetraso;
	
	@OneToOne
	@JoinColumn(name = "lector_id", referencedColumnName = "id")
	private Lector lector;
	
	public Multa() {
		
	}
	
	public Multa(long retraso, Lector lect) {
		LocalDate inicio = LocalDate.now();
		inicioMulta = inicio;
		diasDeRetraso = retraso;
		lector = lect;
	}

	public long diasRestantes() {
		LocalDate fechaActual = LocalDate.now();	
		return ChronoUnit.DAYS.between(fechaActual, inicioMulta.plusDays(diasDeRetraso));
	}
	
}