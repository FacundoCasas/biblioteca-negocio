package excepciones;

public class PrestamoNoVencido extends Exception {

	private static final long serialVersionUID = 1L;

	public PrestamoNoVencido(String mensaje) {
		super(mensaje);
		System.out.println(mensaje);
	}
}
