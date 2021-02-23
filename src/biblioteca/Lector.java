package biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import excepciones.NoPuedePedir;
import excepciones.PrestamoNoVencido;

public class Lector {

	private long nroSocio;
	private String nombre;
	private String telefono;
	private String direccion;
	private List<Prestamo> prestamos;
	private List<Multa> multas;
	static private Date hoy = new Date();
	
	public Lector() {
		this.nroSocio = 0;
		prestamos = new ArrayList<Prestamo>();
		multas = new ArrayList<Multa>();
	}

	public Lector(long nroSocio, String nombre, String telefono, String direccion) {
		this.nroSocio = nroSocio;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		multas = new ArrayList<Multa>();
		prestamos = new ArrayList<Prestamo>();
	}

	public void listarPrestamos() {
		for (Prestamo prestamo : prestamos) {
			System.out.println(prestamo.toString());
		}
	}

	public void listarMultas() {
		for (Multa multa : multas) {
			System.out.println(multa.toString());
		}
	}
	
	public boolean NoPuedePedir() throws NoPuedePedir, PrestamoNoVencido {
		boolean puede = false;
		desmultar();
		if (multas.size() != 0) {
//			puede = true;
			throw new NoPuedePedir("Posee una Multa");
		} else if (PrestamosVencidos()) {
//			puede = true;
		} else if (prestamos.size() >= 3) {
//			puede = true;
			throw new NoPuedePedir("Ya posee su maximo de Prestamos");
		}
		return puede;
	}
	
	private boolean PrestamosVencidos() throws PrestamoNoVencido {
		boolean poseePrestamosVencidos = false;
		if (prestamos.size() == 0) {
			System.out.println("No posee prestamos");
		} else {
			for (Prestamo prestamo : prestamos) {
				if (vencido(prestamo.getFin())) {
					poseePrestamosVencidos = true;
					throw new PrestamoNoVencido("Este Pretamo Esta Vencido: " + prestamo.toString());
				}
			}
		}
		return poseePrestamosVencidos;
	}
	
	private void desmultar() {
		int numeroDeMultas = multas.size();
		if (numeroDeMultas == 1) {
			if (vencido(multas.get(0).getfFin())) {
				System.out.println("Se desmulto :" + this.multas.remove(0).toString());
			}
		}else if (numeroDeMultas > 1) {
			 for(int i=0;i< multas.size();i++){
				 if (vencido(multas.get(i).getfFin())) {
						System.out.println("Se desmulto :" + this.multas.remove(i).toString());
						i--;
					}
			}
		}
		
	}
	
	
	
	private boolean vencido(Date fin) {
		Boolean vencido = false;
		if (hoy.after(fin)) {
			vencido = true;
		}
		return vencido;
	}
	

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public List<Multa> getMultas() {
		return multas;
	}

	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}

	public long getNroSocio() {
		return nroSocio;
	}

	public void setNroSocio(long nroSocio) {
		this.nroSocio = nroSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Lector [nroSocio=" + nroSocio + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion="
				+ direccion + ", prestamos=" + prestamos + ", multas=" + multas + "]";
	}

}
