
public class Init {

	public static void main(String[] args) {

		Autor HR = new Autor("HR", "UK", "1975"); 
		
		Libro Harry1 = new Libro("Harry Potter Y la Piedra Filosofal", tipoLibro.NOVELA, "Editorial 1", "1970", HR);
		Libro Harry2 = new Libro("Harry Potter Y la Orden del Phoenix", tipoLibro.NOVELA, "Editorial 1", "1970", HR);
		
		
		Copia Primera = new Copia(Harry1);
		Copia Segunda = new Copia(Harry1);
		Copia Tercera = new Copia(Harry1);
		
		Copia Cuarta = new Copia(Harry2);
		Copia Quinta = new Copia(Harry2);
		Copia Sexta = new Copia(Harry2);
		
		
		
		Lector Nahue = new Lector("Nahue","1564451220", "Provincia");
		
		Nahue.adquirir(Primera);
		Nahue.adquirir(Segunda);
		Nahue.adquirir(Cuarta);
		Nahue.adquirir(Sexta);
		Nahue.devolver(Primera);
		Nahue.adquirir(Sexta);
		
	}

}
