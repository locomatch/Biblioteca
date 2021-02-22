package biblioteca;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table public class Libro implements Serializable  {

	@Column @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String titulo;
	
	@Column
	private tipoLibro tipoLibro;
	
	@Column
	private String editorial;
	
	@Column
	private int anio;
	
	@OneToOne
	@JoinColumn(name = "autor_id", referencedColumnName = "id")
	private Autor autor;

	
	public Libro(String tit, tipoLibro lib, String edi, int ani, Autor aut) {
		titulo = tit;
		tipoLibro = lib;
		editorial = edi;
		anio = ani;
		autor = aut;
	}


}
