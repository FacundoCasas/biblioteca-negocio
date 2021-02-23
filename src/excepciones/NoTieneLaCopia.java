package excepciones;

public class NoTieneLaCopia extends Exception {

	private static final long serialVersionUID = 1L;

	public NoTieneLaCopia(String mensaje) {
		super(mensaje);
		System.out.println(mensaje);
	}
}
