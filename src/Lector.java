import java.util.ArrayList;

public class Lector {
	
	private static long idCounter = 0;
	
	private String nSocio;
	private String nombre;
	private String telefono;
	private String direccion;
	
	private ArrayList<Copia> copias;
	
	public static synchronized String createID()
	{
	    return String.valueOf(idCounter++);
	}   
	
	public Lector(String nom, String tel, String dir) {
		nSocio = createID();
		nombre = nom;
		telefono = tel;
		direccion = dir;
		copias = new ArrayList<Copia>();
	}
	
	public void adquirir(Copia copia) {
		if(copias.size() < 3) {
			if (copia.estadoActual() == estadoCopia.DISPONIBLE) {
				copias.add(copia);
				copia.cambiarEstado(estadoCopia.PRESTADO);
				System.out.println("Copia Adquirida!");
				
			}
		}
		else
			System.out.println("No se pueden adquirir mas copias");
	}
	
	
	public void devolver(Copia copia) {
		copias.remove(copia);
		copia.cambiarEstado(estadoCopia.DISPONIBLE);
		System.out.println("Copia devuelta!");
	}
	
}
