package biblioteca;

import java.time.LocalDate;

public class Autor {

	
	private String nombre;
	private String nacionalidad;
	private LocalDate nacimiento;
	

	public Autor(String nom, String nacionalid, String nacimient) {
		nombre = nom;
		nacionalidad = nacionalid;
		LocalDate nacim = LocalDate.parse(nacimient);
		nacimiento = nacim;
	}
}