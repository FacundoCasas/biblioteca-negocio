package excepciones;

public class NoPuedePedir extends Exception {

	private static final long serialVersionUID = 1L;

	public NoPuedePedir(String mensaje) {
		super(mensaje);
		System.out.println(mensaje);
	}
	
}
