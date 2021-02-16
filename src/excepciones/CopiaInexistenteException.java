package excepciones;

public class CopiaInexistenteException extends Exception{

	public CopiaInexistenteException() {
		System.out.println("El lector no tiene esta copia");
	}
	
}
