package biblioteca;

import java.util.Date;

import excepciones.PrestamoNoVencido;

public class Multa {
	private Date fInicio;
	private Date fFin;
	private Lector lector;
	private Prestamo prestamo;

	public Multa(Lector lector, Prestamo prestamo) throws PrestamoNoVencido {
		this.fInicio = prestamo.getFin();
		this.fFin = new Date(prestamo.milisegundosVencidos());
		this.lector = lector;
		prestamo.getCopia().setEstado(estadoCopia.RETRASO);
		this.prestamo = prestamo;
	}

	public Date getfInicio() {
		return fInicio;
	}

	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}

	public Date getfFin() {
		return fFin;
	}

	public void setfFin(Date fFin) {
		this.fFin = fFin;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		prestamo.getCopia().setEstado(estadoCopia.RETRASO);
		this.prestamo = prestamo;
	}
	
	
	@Override
	public String toString() {
		return "Multa [fInicio=" + fInicio + ", fFin=" + fFin + ", lector=" + lector.getNombre() + ", prestamo="
				+ prestamo.getCopia().getTitulo() + prestamo.getCopia().getId() + "]";
	}

}
