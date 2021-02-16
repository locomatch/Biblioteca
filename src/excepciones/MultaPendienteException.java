package excepciones;

public class MultaPendienteException extends Exception {

	public MultaPendienteException(long cantDiasRestantes) {
		System.out.println("Multa pendiente: " + cantDiasRestantes + " dias restantes" );
	}
	
}
