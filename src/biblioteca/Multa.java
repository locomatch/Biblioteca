package biblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Multa {

	private LocalDate inicioMulta;
	private long diasDeRetraso;
	private Lector lector;
	

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