package biblioteca;
import javax.persistence.*;
import java.time.LocalDate;
import java.io.Serializable;

@Entity 
@Table public class Autor implements Serializable{

	@Column @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nombre;
	
	@Column
	private String nacionalidad;
	
	@Column
	private LocalDate nacimiento;
	
	public Autor() {
		
	}
	
	public Autor(String nom, String nacionalid, String nacimient) {
		nombre = nom;
		nacionalidad = nacionalid;
		LocalDate nacim = LocalDate.parse(nacimient);
		nacimiento = nacim;
	}
}